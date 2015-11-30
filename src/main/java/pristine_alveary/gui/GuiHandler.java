package pristine_alveary.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import pristine_alveary.gui.container.PristinizatorContainer;
import pristine_alveary.tileentity.TileEntityPristinizator;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GuiHandler implements IGuiHandler {

    public static final int PRISTINIZATOR_INVENTORY_GUI_ID = 0;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;
        switch (id) {
            case PRISTINIZATOR_INVENTORY_GUI_ID:
                tileEntity = world.getTileEntity(x, y, z);
                if (tileEntity instanceof TileEntityPristinizator) {
                    return new PristinizatorContainer(player.inventory, (TileEntityPristinizator) tileEntity);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity;
        switch (id) {
            case PRISTINIZATOR_INVENTORY_GUI_ID:
                tileEntity = world.getTileEntity(x, y, z);
                if (tileEntity instanceof TileEntityPristinizator) {
                    return new GuiPristinizator(player.inventory, (TileEntityPristinizator) tileEntity);
                }
                break;
        }
        return null;
    }
}
