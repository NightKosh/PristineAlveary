package pristine_alveary.tileentity;

import com.mojang.authlib.GameProfile;
import forestry.api.apiculture.IBeeRoot;
import forestry.api.genetics.AlleleManager;
import forestry.api.multiblock.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;

import java.util.Random;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public  class TileEntityBaseAlveary extends MultiblockTileEntityBase<IMultiblockLogicAlveary> implements IAlvearyComponent {

    public IBeeRoot beeRoot = (IBeeRoot) AlleleManager.alleleRegistry.getSpeciesRoot("rootBees");
    protected boolean isInited = false;
    protected boolean isMaster;
    protected int masterX;
    protected int masterY = -99;
    protected int masterZ;
    private int tickCount = new Random().nextInt(128);

    public TileEntityBaseAlveary() {
        super(MultiblockManager.logicFactory.createAlvearyLogic());
    }

    public final boolean updateOnInterval(int tickInterval) {
        return tickCount % tickInterval == 0;
    }

    protected boolean hasMaster() {
        return masterY >= 0;
    }

    @Override
    public GameProfile getOwner() {
        return null;//TODO!!!!!!!!!
    }

    @Override
    public void onMachineAssembled(IMultiblockController multiblockController, ChunkCoordinates minCoord, ChunkCoordinates maxCoord) {
        if (worldObj.isRemote) {
            this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
        worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, getBlockType());
        markDirty();

    }

    @Override
    public void onMachineBroken() {
        if (worldObj.isRemote) {
            this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
        }
        worldObj.notifyBlocksOfNeighborChange(xCoord, yCoord, zCoord, getBlockType());
        markDirty();
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        this.isMaster = nbt.getBoolean("IsMaster");
        this.masterX = nbt.getInteger("MasterX");
        this.masterY = nbt.getInteger("MasterY");
        this.masterZ = nbt.getInteger("MasterZ");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        nbt.setBoolean("IsMaster", this.isMaster);
        nbt.setInteger("MasterX", this.masterX);
        nbt.setInteger("MasterY", this.masterY);
        nbt.setInteger("MasterZ", this.masterZ);
    }

    @Override
    public boolean canUpdate() {
        return super.canUpdate();
    }

}
