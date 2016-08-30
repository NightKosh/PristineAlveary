package pristine_alveary.tileentity;

import forestry.api.apiculture.IBeeModifier;
import forestry.api.multiblock.IAlvearyComponent;
import pristine_alveary.modifier.GeneticDecaySuppressorModifier;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class TileEntityGeneticDecaySuppressor extends TileEntityBaseAlveary implements IAlvearyComponent.BeeModifier {

    private final IBeeModifier modifier = new GeneticDecaySuppressorModifier();

    public TileEntityGeneticDecaySuppressor() {
        super();
    }

    @Override
    public IBeeModifier getBeeModifier() {
        return modifier;
    }
}
