package ru.pearx.jehc.jei.trap;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

/*
 * Created by mrAppleXZ on 19.07.17 10:39.
 */
public abstract class TrapRecipeWrapper implements IRecipeWrapper
{
    private final ItemStack in;
    private final ItemStack out;

    public TrapRecipeWrapper(ItemStack in, ItemStack out)
    {
        this.in = in;
        this.out = out;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInput(ItemStack.class, in);
        ingredients.setOutput(ItemStack.class, out);
    }

    public static class Ground extends TrapRecipeWrapper
    {
        public Ground(ItemStack in, ItemStack out)
        {
            super(in, out);
        }
    }

    public static class Water extends TrapRecipeWrapper
    {
        public Water(ItemStack in, ItemStack out)
        {
            super(in, out);
        }
    }
}
