package pristine_alveary.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pristine_alveary.Resources;
import pristine_alveary.tileentity.TileEntityIgnobleStabilizator;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockIgnobleStabilizator extends BlockAlvearyBase {

    public BlockIgnobleStabilizator() {
        super();
        this.setBlockName("IgnobleStabilizator");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityIgnobleStabilizator();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        sideIcon = iconRegister.registerIcon(Resources.IGNOBLE_STABILIZATOR);
    }
}
