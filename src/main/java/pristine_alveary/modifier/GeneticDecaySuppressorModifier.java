package pristine_alveary.modifier;

import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeModifier;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GeneticDecaySuppressorModifier implements IBeeModifier {

    @Override
    public float getTerritoryModifier(IBeeGenome genome, float currentModifier) {
        return 1;
    }

    @Override
    public float getMutationModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier) {
        return 1;
    }

    @Override
    public float getLifespanModifier(IBeeGenome genome, IBeeGenome mate, float currentModifier) {
        return 1;
    }

    @Override
    public float getProductionModifier(IBeeGenome genome, float currentModifier) {
        return 1;
    }

    @Override
    public float getFloweringModifier(IBeeGenome genome, float currentModifier) {
        return 1;
    }

    @Override
    public float getGeneticDecay(IBeeGenome genome, float currentModifier) {
        return 0;
    }

    @Override
    public boolean isSealed() {
        return false;
    }

    @Override
    public boolean isSelfLighted() {
        return false;
    }

    @Override
    public boolean isSunlightSimulated() {
        return false;
    }

    @Override
    public boolean isHellish() {
        return false;
    }
}
