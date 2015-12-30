package pristine_alveary.tileentity;

import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.core.ITileStructure;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import pristine_alveary.inventory.PristinizatorInventory;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityPristinizator extends TileEntityBaseAlveary {

    private PristinizatorInventory inventory;

    public TileEntityPristinizator() {
        super();
        inventory = new PristinizatorInventory();
    }

    @Override
    public void initialize() {

    }

    @Override
    protected void updateServerSide() {
        super.updateServerSide();
        if (hasMaster()) {
            if (updateOnInterval(1000)) {
                ITileStructure centralTe = this.getCentralTE();
                if (centralTe != null) {
                    if (!inventory.isEmpty()) {
                        IBeeHousing beeHousing = (IBeeHousing) centralTe;
                        ItemStack queenItem = beeHousing.getQueen();
                        if (queenItem != null && !this.beeRoot.getMember(queenItem).isNatural()) {
                            inventory.removeOneItem();
                            if (this.getWorldObj().rand.nextInt(250) == 0) {
                                IBee bee = this.beeRoot.getMember(queenItem);
                                bee.setIsNatural(true);
                                queenItem = this.beeRoot.getMemberStack(bee, EnumBeeType.QUEEN.ordinal());
                                beeHousing.setQueen(queenItem);
                            }
                        }
                    }
                }
            }
        }
    }

    public IInventory getInventory() {
        return inventory;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);

        inventory.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);

        inventory.writeToNBT(nbt);
    }
}
