package net.pearx.jehc.jei.sbm;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.JehcRecipeCategory;

/*
 * Created by mrAppleXZ on 20.05.17 23:54.
 */
@SideOnly(Side.CLIENT)
public abstract class SBMRecipeCategory extends JehcRecipeCategory<IRecipeWrapper> {
    private Class<? extends GuiContainer> guiClass;

    public SBMRecipeCategory(String uid, ItemStack catalyst, String png, IGuiHelper helper, Class<? extends GuiContainer> guiClass) {
        super(uid, catalyst, helper.drawableBuilder(new ResourceLocation("harvestcraft", "textures/gui/" + png + ".png"), 32, 0, 112, 76).build());
        this.guiClass = guiClass;
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        registry.addRecipeClickArea(guiClass, 99, 15, 36, 18, getUid());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, IRecipeWrapper recipeWrapper, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0, false, 40, 25);
        recipeLayout.getItemStacks().set(0, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
        recipeLayout.getItemStacks().init(1, true, 80, 47);
        recipeLayout.getItemStacks().set(1, ingredients.getInputs(VanillaTypes.ITEM).get(0));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void drawExtras(Minecraft minecraft) {
        String s = I18n.format("jehc.price");
        int width = minecraft.fontRenderer.getStringWidth(s);
        minecraft.fontRenderer.drawString(s, 67 + ((37 - width) / 2), 25 + ((18 - minecraft.fontRenderer.FONT_HEIGHT) / 2), 0);
    }
}
