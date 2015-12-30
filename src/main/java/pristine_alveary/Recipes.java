package pristine_alveary;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class Recipes {

    private Recipes() {
    }

    public static void initialize() {

        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockIgnobleStabilizator), "eae", "dbd", "aaa", 'b', ForestryItems.alveary, 'a', ForestryItems.ambrosia, 'e', ForestryItems.emeraldTube, 'd', ForestryItems.diamondTube);
//        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockGeneticDecaySuppressor), "xex", "dbd", "xex", 'b', ForestryItems.alveary, 'e', ForestryItems.emeraldTube, 'd', ForestryItems.diamondTube, 'x', ForestryItems.enderTube);
        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockPristinizator), "xsx", "ebe", "xax", 'b', PristineAlvearyMod.blockIgnobleStabilizator, 'a', ForestryItems.ambrosia, 'e', ForestryItems.emeraldTube, 'x', ForestryItems.enderTube, 's', Items.nether_star);
        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockLifeReducer), "xsx", "nbn", "ede", 'b', ForestryItems.alveary, 'e', ForestryItems.emeraldTube, 'd', ForestryItems.diamondTube, 'x', ForestryItems.enderTube, 'n', ForestryItems.blazeTube, 's', Items.nether_star);
    }
}
