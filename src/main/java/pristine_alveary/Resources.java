package pristine_alveary;

import net.minecraft.util.ResourceLocation;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Resources {
    private Resources() {
    }
    private static final String MOD_NAME = ModInfo.ID.toLowerCase();
    private static final String FORESTRY_MOD_NAME = "forestry";

    public static final String ALVEARY_PLAIN =  FORESTRY_MOD_NAME + ":apiculture/alveary.plain";
    public static final String ALVEARY_BOTTOM =  FORESTRY_MOD_NAME + ":apiculture/alveary.bottom";

    public static final String IGNOBLE_STABILIZATOR = MOD_NAME + ":IgnobleStabilizator";
    public static final String GENETIC_DECAY_SUPPRESSOR = MOD_NAME + ":GeneticDecaySuppressor";
    public static final String PRISTINIZATOR = MOD_NAME + ":Pristinizator";
    public static final String LIFE_REDUCES = MOD_NAME + ":LifeReducer";
    public static final String MUTATOR = MOD_NAME + ":Mutator";

    public static final ResourceLocation PRISTINIZATOR_GUI = new ResourceLocation(FORESTRY_MOD_NAME + ":textures/gui/swarmer.png");

}
