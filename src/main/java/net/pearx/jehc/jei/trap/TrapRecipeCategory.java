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

package net.pearx.jehc.jei.trap;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.JehcRecipeCategory;

@SideOnly(Side.CLIENT)
public abstract class TrapRecipeCategory extends JehcRecipeCategory<TrapRecipeWrapper> {
    private Class<? extends GuiContainer> guiClass;
    private Class<? extends Container> containerClass;

    public TrapRecipeCategory(String uid, ItemStack catalyst, String png, IGuiHelper help, Class<? extends GuiContainer> guiClass, Class<? extends Container> containerClass) {
        super(uid, catalyst, help.drawableBuilder(new ResourceLocation("jehc", "textures/gui/" + png + "_trap_small.png"), 0, 0, 81, 29).setTextureSize(81, 29).build());
        this.guiClass = guiClass;
        this.containerClass = containerClass;
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        registry.addRecipeClickArea(guiClass, 5, 52, 56, 18, getUid());
        registry.getRecipeTransferRegistry().addRecipeTransferHandler(containerClass, getUid(), 18, 1, 19, 36);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, TrapRecipeWrapper recipeWrapper, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0, true, 22, 8);
        recipeLayout.getItemStacks().set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        recipeLayout.getItemStacks().init(1, false, 58, 8);
        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
