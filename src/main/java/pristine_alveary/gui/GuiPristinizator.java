package pristine_alveary.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;
import pristine_alveary.Resources;
import pristine_alveary.gui.container.PristinizatorContainer;
import pristine_alveary.tileentity.TileEntityPristinizator;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class GuiPristinizator extends GuiContainer {

    public GuiPristinizator(InventoryPlayer inventoryPlayer, TileEntityPristinizator tileEntity) {
        super(new PristinizatorContainer(inventoryPlayer, tileEntity));
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1, 1, 1, 1);
        this.mc.renderEngine.bindTexture(Resources.PRISTINIZATOR_GUI);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
