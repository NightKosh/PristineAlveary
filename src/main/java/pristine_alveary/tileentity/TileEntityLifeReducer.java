package pristine_alveary.tileentity;

import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import pristine_alveary.modifier.LifeReducerModifier;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityLifeReducer extends TileEntityBaseAlveary implements IAlvearyComponent.BeeModifier {

    private static final IBeeModifier modifier = new LifeReducerModifier();

    public TileEntityLifeReducer() {
        super();
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return modifier;
    }
}
