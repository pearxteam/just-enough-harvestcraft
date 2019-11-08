package ru.pearx.jehc.jei.apiary;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/*
 * Created by mrAppleXZ on 21.05.17 11:41.
 */
@SideOnly(Side.CLIENT)
public class ApiaryRecipeWrapper implements IRecipeWrapper {
    private ItemStack out;
    private ItemStack in;
    private int chance;

    public ApiaryRecipeWrapper(ItemStack in, ItemStack out, int chance) {
        this.out = out;
        this.in = in;
        this.chance = chance;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.ITEM, in);
        ingredients.setOutput(VanillaTypes.ITEM, out);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        String result = chance + "%";
        int w = minecraft.fontRenderer.getStringWidth(result);
        minecraft.fontRenderer.drawString(result, 6 + ((50 - w) / 2), 48 + ((11 - minecraft.fontRenderer.FONT_HEIGHT) / 2), 0);
    }
}
