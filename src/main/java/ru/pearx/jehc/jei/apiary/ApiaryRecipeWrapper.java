package ru.pearx.jehc.jei.apiary;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

/*
 * Created by mrAppleXZ on 21.05.17 11:41.
 */
public class ApiaryRecipeWrapper extends BlankRecipeWrapper
{
    private ItemStack out;
    private ItemStack in;
    private int percents;

    public ApiaryRecipeWrapper(ItemStack in, ItemStack out, int percents)
    {
        this.out = out;
        this.in = in;
        this.percents = percents;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInput(ItemStack.class, in);
        ingredients.setOutput(ItemStack.class, out);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
    {
        String s = percents + "%";
        int w = minecraft.fontRenderer.getStringWidth(s);
        minecraft.fontRenderer.drawString(s, 6 + ((50 - w) / 2), 48 + ((11 - minecraft.fontRenderer.FONT_HEIGHT) / 2), Color.BLACK.getRGB());
    }
}
