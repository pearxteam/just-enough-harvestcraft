package ru.pearx.jehc.jei;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrAppleXZ on 20.05.17 16:07.
 */
public class PresserRecipeWrapper extends BlankRecipeWrapper
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
        List<ItemStack> outputs = new ArrayList<ItemStack>();
        for (ItemStack st : out)
        {
            if(st != null)
                outputs.add(st);
        }
        ingredients.setOutputs(ItemStack.class, outputs);
    }

}
