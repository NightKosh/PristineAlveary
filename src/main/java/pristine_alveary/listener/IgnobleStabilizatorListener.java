package pristine_alveary.listener;

import forestry.api.apiculture.DefaultBeeListener;
import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeHousingInventory;
import forestry.api.multiblock.IMultiblockLogicAlveary;
import net.minecraft.item.ItemStack;
import pristine_alveary.tileentity.TileEntityBaseAlveary;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class IgnobleStabilizatorListener extends DefaultBeeListener {
    private boolean wasChanged = false;
    private TileEntityBaseAlveary alveary;

    public IgnobleStabilizatorListener(TileEntityBaseAlveary alveary) {
        this.alveary = alveary;
    }

    /**
     * Called just before the children are generated, and the queen removed.
     */
    @Override
    public void onQueenDeath() {
        IMultiblockLogicAlveary logic = alveary.getMultiblockLogic();
        if (logic.getController().isAssembled()) {
            IBeeHousingInventory inventory = logic.getController().getBeeInventory();
            if (inventory != null) {
                ItemStack queenItem = inventory.getQueen();
                IBee queen = alveary.beeRoot.getMember(queenItem);
                if (!queen.isNatural()) {
                    wasChanged = true;
                    queen.setIsNatural(true);
                }
            }
        }
    }

    /**
     * Called after the children have been spawned, but before the queen appears
     */
//    @Override
    public void onPostQueenDeath(IBee queen) {
        if (wasChanged) {
//            ITileStructure centralTE = alveary.getCentralTE();
//            if (centralTE != null) {
            IMultiblockLogicAlveary logic = alveary.getMultiblockLogic();
            if (logic.getController().isAssembled()) {
//                ISidedInventory inventory = centralTE.getStructureInventory();
                IBeeHousingInventory inventory = logic.getController().getBeeInventory();
                if (inventory != null) {
//                    for (int i = 0; i < inventory.getSizeInventory(); i++) {
//                        ItemStack item = inventory.getStackInSlot(i);

                    ItemStack item = inventory.getQueen();
                    if (item != null && alveary.beeRoot.isMember(item) && !alveary.beeRoot.isDrone(item) && alveary.beeRoot.getMember(item).isNatural()) {
                        IBee bee = alveary.beeRoot.getMember(item);
                        bee.setIsNatural(false);
                        item = alveary.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS.ordinal());
//                            inventory.setInventorySlotContents(i, item);
                        inventory.setQueen(item);
                    }
                }
            }
        }
        wasChanged = false;
        queen.setIsNatural(false);
    }
}
