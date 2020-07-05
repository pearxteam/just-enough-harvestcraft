/*
 * This file is part of Just Enough HarvestCraft.
 *
 * Just Enough HarvestCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Just Enough HarvestCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Just Enough HarvestCraft.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.pearx.jehc.jei.sbm;

import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.recipe.transfer.IRecipeTransferError;
import mezz.jei.api.recipe.transfer.IRecipeTransferHandler;
import mezz.jei.gui.recipes.RecipesGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.Jehc;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.List;

@SideOnly(Side.CLIENT)
public abstract class SBMRecipeTransferHandler<C extends Container, G extends GuiScreen, TE extends TileEntity> implements IRecipeTransferHandler<C> {
    private Class<C> containerClass;
    private Class<G> guiClass;
    private Field fieldItemNum;
    private Field fieldTileEntity;

    public SBMRecipeTransferHandler(Class<C> containerClass, Class<G> guiClass, String tileEntityFieldName) {
        this.containerClass = containerClass;
        this.guiClass = guiClass;
        setupFields(tileEntityFieldName);
    }

    private void setupFields(String tileEntityFieldName) {
        fieldItemNum = FieldUtils.getDeclaredField(guiClass, "itemNum", true);
        fieldTileEntity = FieldUtils.getDeclaredField(guiClass, tileEntityFieldName, true);
    }

    @Override
    public Class<C> getContainerClass() {
        return containerClass;
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public IRecipeTransferError transferRecipe(C container, IRecipeLayout recipeLayout, EntityPlayer player, boolean maxTransfer, boolean doTransfer) {
        if (doTransfer) {
            try {
                GuiScreen screen = Minecraft.getMinecraft().currentScreen;
                if (screen instanceof RecipesGui) {
                    GuiScreen parentScreen = ((RecipesGui) screen).getParentScreen();
                    if (guiClass.isInstance(parentScreen)) {
                        List<ItemStack> recipeIns = recipeLayout.getItemStacks().getGuiIngredients().get(1).getAllIngredients();
                        List<ItemStack> recipeOuts = recipeLayout.getItemStacks().getGuiIngredients().get(0).getAllIngredients();

                        int itemNum = -1;
                        outer:
                        for (int i = 0; i < getRegistrySize(); i++) {
                            Pair<ItemStack, ItemStack> p = getRecipe(i);
                            ItemStack datIn = p.getLeft();
                            ItemStack datOut = p.getRight();

                            for (ItemStack recipeIn : recipeIns) {
                                for (ItemStack recipeOut : recipeOuts) {
                                    if (ItemStack.areItemStacksEqualUsingNBTShareTag(recipeIn, datIn) && ItemStack.areItemStacksEqualUsingNBTShareTag(recipeOut, datOut)) {
                                        {
                                            itemNum = i;
                                            break outer;
                                        }
                                    }
                                }
                            }
                        }
                        if (itemNum >= 0) {
                            FieldUtils.writeField(fieldItemNum, parentScreen, itemNum);
                            setBrowsingInfo((TE) FieldUtils.readField(fieldTileEntity, parentScreen), itemNum);
                        }
                    }
                }
            }
            catch (Exception e) {
                Jehc.INSTANCE.getLog().error("An error occurred while transferring shipping bin or market recipe!", e);
            }
        }
        return null;
    }

    public abstract void setBrowsingInfo(TE tileEntity, int itemNum);

    public abstract int getRegistrySize();

    public abstract Pair<ItemStack, ItemStack> getRecipe(int itemNum);
}
