package pristine_alveary.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pristine_alveary.Resources;
import pristine_alveary.tileentity.TileEntityLifeReducer;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockLifeReducer extends BlockAlvearyBase {

    public BlockLifeReducer() {
        super();
        this.setBlockName("LifeReducer");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityLifeReducer();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        sideIcon = iconRegister.registerIcon(Resources.LIFE_REDUCES);
    }
}