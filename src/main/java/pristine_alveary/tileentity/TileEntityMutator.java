package pristine_alveary.tileentity;

import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import pristine_alveary.modifier.MutatorModifier;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityMutator extends TileEntityBaseAlveary implements IAlvearyComponent.BeeModifier {

    private static final IBeeModifier modifier = new MutatorModifier();

    public TileEntityMutator() {
        super();
    }


    @Override
    public IBeeModifier getBeeModifier() {
        return modifier;
    }
}
