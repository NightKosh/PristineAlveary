package pristine_alveary.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import forestry.api.core.Tabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import pristine_alveary.Resources;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public abstract class BlockAlvearyBase extends BlockContainer {

    public BlockAlvearyBase() {
        super(Material.wood);
        setHardness(1);
        setCreativeTab(Tabs.tabApiculture);
    }

    @SideOnly(Side.CLIENT)
    protected IIcon bottomIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon sideIcon;

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
//        sideIcon = iconRegister.registerIcon(iconRegister.registerIcon(Resources.ALVEARY_PLAIN);
        bottomIcon = iconRegister.registerIcon(Resources.ALVEARY_BOTTOM);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metadata) {
        return (side == 1 || side == 0) ? bottomIcon : sideIcon;
    }
}