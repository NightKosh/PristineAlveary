package pristine_alveary.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pristine_alveary.PristineAlvearyMod;
import pristine_alveary.Resources;
import pristine_alveary.gui.GuiHandler;
import pristine_alveary.tileentity.TileEntityPristinizator;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class BlockPristinizator extends BlockAlvearyBase {

    public BlockPristinizator() {
        super();
        this.setBlockName("Pristinizator");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityPristinizator();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        super.registerBlockIcons(iconRegister);
        sideIcon = iconRegister.registerIcon(Resources.PRISTINIZATOR);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        player.openGui(PristineAlvearyMod.instance, GuiHandler.PRISTINIZATOR_INVENTORY_GUI_ID, world, x, y, z);
        return true;
    }
}
