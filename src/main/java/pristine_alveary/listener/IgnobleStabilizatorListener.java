package pristine_alveary.listener;

import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeListener;
import forestry.api.core.ITileStructure;
import forestry.api.genetics.IIndividual;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import pristine_alveary.tileentity.TileEntityBaseAlveary;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class IgnobleStabilizatorListener implements IBeeListener {
    private boolean wasChanged = false;
    private TileEntityBaseAlveary alveary;

    public IgnobleStabilizatorListener(TileEntityBaseAlveary alveary) {
        this.alveary = alveary;
    }

    @Override
    public void onQueenChange(ItemStack queen) {
    }

    @Override
    public void wearOutEquipment(int amount) {
    }

    /**
     * Called just before the children are generated, and the queen removed.
     */
    @Override
    public void onQueenDeath(IBee queen) {
        if (!queen.isNatural()) {
            wasChanged = true;
            queen.setIsNatural(true);
        }
    }

    /**
     * Called after the children have been spawned, but before the queen appears
     */
    @Override
    public void onPostQueenDeath(IBee queen) {
        if (wasChanged) {
            ITileStructure centralTE = alveary.getCentralTE();
            if (centralTE != null) {
                ISidedInventory inventory = centralTE.getStructureInventory();
                if (inventory != null) {
                    for (int i = 0; i < inventory.getSizeInventory(); i++) {
                        ItemStack item = inventory.getStackInSlot(i);
                        if (item != null && alveary.beeRoot.isMember(item) && !alveary.beeRoot.isDrone(item) && alveary.beeRoot.getMember(item).isNatural()) {
                            IBee bee = alveary.beeRoot.getMember(item);
                            bee.setIsNatural(false);
                            item = alveary.beeRoot.getMemberStack(bee, EnumBeeType.PRINCESS.ordinal());
                            inventory.setInventorySlotContents(i, item);
                        }
                    }
                }
            }
            wasChanged = false;
            queen.setIsNatural(false);
        }
    }

    @Override
    public boolean onPollenRetrieved(IBee queen, IIndividual pollen, boolean isHandled) {
        return false;
    }

    @Override
    public boolean onEggLaid(IBee queen) {
        return false;
    }
}
