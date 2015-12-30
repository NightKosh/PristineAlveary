package pristine_alveary.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * PristineAlveary mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class PristinizatorInventory implements IInventory {

    ItemStack[] inventory = new ItemStack[4];

    public void readFromNBT(NBTTagCompound nbt) {
        NBTTagList ntbItemsList = nbt.getTagList("Items", 10);
        for (int slot = 0; slot < ntbItemsList.tagCount(); slot++) {
            NBTTagCompound itemNbt = ntbItemsList.getCompoundTagAt(slot);
            ItemStack stack = ItemStack.loadItemStackFromNBT(itemNbt);
            if (stack != null) {
                inventory[slot] = stack;
            }
        }
    }

    public void writeToNBT(NBTTagCompound nbt) {
        NBTTagList ntbList = new NBTTagList();

        for (ItemStack stack : inventory) {
            if (stack != null) {
                NBTTagCompound itemNbt = new NBTTagCompound();
                stack.writeToNBT(itemNbt);
                ntbList.appendTag(itemNbt);
            }
        }

        nbt.setTag("Items", ntbList);
    }

    @Override
    public int getSizeInventory() {
        return 4;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amount) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amount);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return getStackInSlot(slot);
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
    }

    @Override
    public String getInventoryName() {
        return "";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack) {
        return true;//TODO
    }

    public boolean isEmpty() {
        for (ItemStack stack : inventory) {
            if (stack != null) {
                return false;
            }
        }
        return true;
    }

    public void removeOneItem() {
        for (int slot = 0; slot < inventory.length; slot++) {
            if (inventory[slot] != null) {
                decrStackSize(slot, 1);
                break;
            }
        }
    }
}
