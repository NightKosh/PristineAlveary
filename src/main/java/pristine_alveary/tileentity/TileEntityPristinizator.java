package pristine_alveary.tileentity;

import forestry.api.apiculture.EnumBeeType;
import forestry.api.apiculture.IBee;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.core.ITileStructure;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import pristine_alveary.inventory.PristinizatorInventory;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityPristinizator extends TileEntityBaseAlveary {

    private IInventory inventory;

    public TileEntityPristinizator() {
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
                    //TODO check and get resources
                    IBeeHousing beeHousing = (IBeeHousing) centralTe;
                    ItemStack queenItem = beeHousing.getQueen();
                    if (queenItem != null && !this.beeRoot.getMember(queenItem).isNatural()) {
                        IBee bee = this.beeRoot.getMember(queenItem);
                        bee.setIsNatural(true);
                        queenItem = this.beeRoot.getMemberStack(bee, EnumBeeType.QUEEN.ordinal());
                        beeHousing.setQueen(queenItem);
                    }
                }
            }
        }
    }

    public IInventory getInventory() {
        return inventory;
    }
}
