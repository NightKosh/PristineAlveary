package pristine_alveary.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pristine_alveary.Resources;
import pristine_alveary.tileentity.TileEntityGeneticDecaySuppressor;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockGeneticDecaySuppressor extends BlockAlvearyBase {

    public BlockGeneticDecaySuppressor() {
        super();
        this.setBlockName("GeneticDecaySuppressor");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityGeneticDecaySuppressor();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        sideIcon = iconRegister.registerIcon(Resources.GENETIC_DECAY_SUPPRESSOR);
    }
}
