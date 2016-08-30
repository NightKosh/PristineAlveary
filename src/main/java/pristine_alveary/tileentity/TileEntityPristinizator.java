package pristine_alveary.tileentity;

import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeHousingInventory;
import forestry.api.multiblock.IMultiblockLogicAlveary;
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

    protected void updateServerSide() {
        if (hasMaster()) {
            if (updateOnInterval(1000)) {
//                ITileStructure centralTe = this.getCentralTE();
//                if (centralTe != null) {
                IMultiblockLogicAlveary logic = this.getMultiblockLogic();
                if (logic.getController().isAssembled()) {
                    if (!inventory.isEmpty()) {
                        IBeeHousingInventory beeHousingInventory = logic.getController().getBeeInventory();
                        ItemStack queenItem = beeHousingInventory.getQueen();
                        if (queenItem != null && !this.beeRoot.getMember(queenItem).isNatural()) {
                            inventory.removeOneItem();
                            if (this.getWorldObj().rand.nextInt(250) == 0) {
                                IBee bee = this.beeRoot.getMember(queenItem);
                                bee.setIsNatural(true);
                                queenItem = this.beeRoot.getMemberStack(bee, EnumBeeType.QUEEN.ordinal());
                                beeHousingInventory.setQueen(queenItem);
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
