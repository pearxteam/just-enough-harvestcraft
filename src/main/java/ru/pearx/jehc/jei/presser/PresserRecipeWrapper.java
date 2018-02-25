package ru.pearx.jehc.jei.presser;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by mrAppleXZ on 20.05.17 16:07.
 */
public class PresserRecipeWrapper implements IRecipeWrapper
{
    private final ItemStack in;
    private final ItemStack[] out;

    public PresserRecipeWrapper(ItemStack in, ItemStack[] out)
    {
        this.in = in;
        this.out = out;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInput(ItemStack.class, in);
        List<ItemStack> outputs = new ArrayList<>();
        for (ItemStack st : out)
        {
            if(st != null)
                outputs.add(st);
        }
        ingredients.setOutputs(ItemStack.class, outputs);
    }

}
