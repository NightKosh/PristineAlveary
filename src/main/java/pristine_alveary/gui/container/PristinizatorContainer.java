package pristine_alveary.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import pristine_alveary.tileentity.TileEntityPristinizator;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PristinizatorContainer extends Container {

    protected TileEntityPristinizator tileEntity;
    public static final int PLAYER_INVENTORY_ROWS_COUNT = 3;
    public static final int COLUMNS_COUNT = 9;
    public static final int SLOT_WIDTH = 18;

    public PristinizatorContainer(InventoryPlayer inventoryPlayer, TileEntityPristinizator te) {
        tileEntity = te;

        this.addSlotToContainer(new PristinizatorSlot(tileEntity.getInventory(), 0, 79, 52));
        this.addSlotToContainer(new PristinizatorSlot(tileEntity.getInventory(), 1, 100, 39));
        this.addSlotToContainer(new PristinizatorSlot(tileEntity.getInventory(), 2, 58, 39));
        this.addSlotToContainer(new PristinizatorSlot(tileEntity.getInventory(), 3, 79, 26));

        for (int row = 0; row < PLAYER_INVENTORY_ROWS_COUNT; row++) {
            for (int column = 0; column < COLUMNS_COUNT; column++) {
                addSlotToContainer(new Slot(inventoryPlayer, column + row * COLUMNS_COUNT + COLUMNS_COUNT, 8 + column * SLOT_WIDTH, 87 + row * SLOT_WIDTH));
            }
        }
        for (int column = 0; column < COLUMNS_COUNT; column++) {
            addSlotToContainer(new Slot(inventoryPlayer, column, 8 + column * SLOT_WIDTH, 145));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            if (slot < tileEntity.getInventory().getSizeInventory()) {
                if (!this.mergeItemStack(stackInSlot, tileEntity.getInventory().getSizeInventory(), 36 + tileEntity.getInventory().getSizeInventory(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(stackInSlot, 0, tileEntity.getInventory().getSizeInventory(), false)) {
                return null;
            }

            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);
            } else {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}
