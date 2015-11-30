package pristine_alveary;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
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
        ItemStack alveary = new ItemStack(GameRegistry.findBlock("Forestry", "alveary"), 1, 0);

        Item ambrosia = GameRegistry.findItem("Forestry", "ambrosia");

        Item tube = GameRegistry.findItem("Forestry", "thermionicTubes");

        ItemStack diamondTube = new ItemStack(tube, 1, 5);
        ItemStack emeraldTube = new ItemStack(tube, 1, 9);
        ItemStack blazeTube = new ItemStack(tube, 1, 7);
        ItemStack enderTube = new ItemStack(tube, 1, 12);

        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockIgnobleStabilizator), "eae", "dbd", "aaa", 'b', alveary, 'a', ambrosia, 'e', emeraldTube, 'd', diamondTube);
        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockGeneticDecaySuppressor), "xex", "dbd", "xex", 'b', alveary, 'e', emeraldTube, 'd', diamondTube, 'x', enderTube);
        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockPristinizator), "xsx", "ebe", "xax", 'b', PristineAlvearyMod.blockIgnobleStabilizator, 'a', ambrosia, 'e', emeraldTube, 'x', enderTube, 's', Items.nether_star);
        GameRegistry.addRecipe(new ItemStack(PristineAlvearyMod.blockLifeReducer), "xsx", "nbn", "ede", 'b', alveary, 'e', emeraldTube, 'd', diamondTube, 'x', enderTube, 'n', blazeTube, 's', Items.nether_star);
    }
}
