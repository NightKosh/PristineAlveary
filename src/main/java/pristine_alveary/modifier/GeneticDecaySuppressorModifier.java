package pristine_alveary.modifier;

import forestry.api.apiculture.DefaultBeeModifier;
import forestry.api.apiculture.IBeeGenome;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GeneticDecaySuppressorModifier extends DefaultBeeModifier {

    @Override
    public float getGeneticDecay(IBeeGenome genome, float currentModifier) {
        return 0;
    }
}
