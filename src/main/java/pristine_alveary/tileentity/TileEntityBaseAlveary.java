package pristine_alveary.tileentity;

import forestry.api.apiculture.IAlvearyComponent;
import forestry.api.apiculture.IBeeListener;
import forestry.api.apiculture.IBeeModifier;
import forestry.api.apiculture.IBeeRoot;
import forestry.api.core.IStructureLogic;
import forestry.api.core.ITileStructure;
import forestry.api.genetics.AlleleManager;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import java.util.Random;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class TileEntityBaseAlveary extends TileEntity implements IAlvearyComponent {

    public IBeeRoot beeRoot = (IBeeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootBees");
    protected final IStructureLogic structureLogic;
    protected boolean isInited = false;
    protected boolean isMaster;
    protected int masterX;
    protected int masterY = -99;
    protected int masterZ;
    private int tickCount = new Random().nextInt(128);

    public TileEntityBaseAlveary() {
        this.structureLogic = beeRoot.createAlvearyStructureLogic(this);
    }

    @Override
    public void registerBeeModifier(IBeeModifier modifier) {

    }

    @Override
    public void removeBeeModifier(IBeeModifier modifier) {

    }

    @Override
    public void registerBeeListener(IBeeListener event) {

    }

    @Override
    public void removeBeeListener(IBeeListener event) {

    }

    @Override
    public void addTemperatureChange(float change, float boundaryDown, float boundaryUp) {

    }

    @Override
    public void addHumidityChange(float change, float boundaryDown, float boundaryUp) {

    }

    @Override
    public boolean hasFunction() {
        return true;
    }

    @Override
    public String getTypeUID() {
        return this.structureLogic.getTypeUID();
    }

    @Override
    public void validateStructure() {
        this.structureLogic.validateStructure();
    }

    @Override
    public void onStructureReset() {
        setCentralTE(null);
        if (worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 1) {
            worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 0);
        }
        isMaster = false;
        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    public abstract void initialize();

    @Override
    public void updateEntity() {
        super.updateEntity();
        tickCount++;

        if (!isInited) {
            initialize();
            isInited = true;
        }

        if (this.worldObj != null && worldObj.isRemote) {
            updateClientSide();
        } else {
            // Periodic validation if needed
            if (updateOnInterval(200) && (!isIntegratedIntoStructure() || isMaster())) {
                validateStructure();
            }
            updateServerSide();
        }
    }

    public final boolean updateOnInterval(int tickInterval) {
        return tickCount % tickInterval == 0;
    }

    protected void updateServerSide() {
    }

    protected void updateClientSide() {
    }

    @Override
    public ITileStructure getCentralTE() {
        if (!isIntegratedIntoStructure()) {
            return null;
        }

        if (isMaster()) {
            return this;
        } else {
            TileEntity te = this.worldObj.getTileEntity(this.masterX, this.masterY, this.masterZ);
            if (te instanceof ITileStructure) {
                ITileStructure master = (ITileStructure) te;
                if (master.isMaster()) {
                    return master;
                }
            }
            return null;
        }
    }

    protected boolean isSameTile(TileEntity tile) {
        return tile.xCoord == xCoord && tile.yCoord == yCoord && tile.zCoord == zCoord;
    }

    @Override
    public void setCentralTE(TileEntity tile) {
        if (tile == null || tile == this || isSameTile(tile)) {
            this.masterX = this.masterZ = 0;
            this.masterY = -99;
            return;
        }

        this.isMaster = false;
        this.masterX = tile.xCoord;
        this.masterY = tile.yCoord;
        this.masterZ = tile.zCoord;
    }

    @Override
    public ISidedInventory getStructureInventory() {
        return null;
    }

    @Override
    public void makeMaster() {
    }

    @Override
    public boolean isMaster() {
        return false;
    }

    protected boolean hasMaster() {
        return masterY >= 0;
    }

    @Override
    public boolean isIntegratedIntoStructure() {
        return isMaster || masterY > 0;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        this.isMaster = nbt.getBoolean("IsMaster");
        this.masterX = nbt.getInteger("MasterX");
        this.masterY = nbt.getInteger("MasterY");
        this.masterZ = nbt.getInteger("MasterZ");

        if (this.isMaster) {
            makeMaster();
        }

        this.structureLogic.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setBoolean("IsMaster", this.isMaster);
        nbt.setInteger("MasterX", this.masterX);
        nbt.setInteger("MasterY", this.masterY);
        nbt.setInteger("MasterZ", this.masterZ);

        this.structureLogic.writeToNBT(nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
    }

    @Override
    public boolean canUpdate() {
        return super.canUpdate();
    }
}
