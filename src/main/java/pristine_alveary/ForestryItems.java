package pristine_alveary;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class ForestryItems {
    private ForestryItems() {
    }

    public static final ItemStack alveary = new ItemStack(GameRegistry.findBlock("Forestry", "alveary"), 1, 0);

    public static final Item ambrosia = GameRegistry.findItem("Forestry", "ambrosia");

    public static final Item tube = GameRegistry.findItem("Forestry", "thermionicTubes");

    public static final ItemStack diamondTube = new ItemStack(tube, 1, 5);
    public static final ItemStack emeraldTube = new ItemStack(tube, 1, 9);
    public static final ItemStack blazeTube = new ItemStack(tube, 1, 7);
    public static final ItemStack enderTube = new ItemStack(tube, 1, 12);
}
