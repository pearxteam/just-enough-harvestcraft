package ru.pearx.jehc.jei.machine;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by mrAppleXZ on 22.03.18 20:58.
 */
public class MachineRecipeWrapper implements IRecipeWrapper
{
    private final ItemStack in;
    private final ItemStack[] out;

    public MachineRecipeWrapper(ItemStack in, ItemStack[] out)
    {
        this.in = in;
        this.out = out;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInput(VanillaTypes.ITEM, in);
        List<ItemStack> outputs = new ArrayList<>();
        for (ItemStack st : out)
        {
            if(st != null)
                outputs.add(st);
        }
        ingredients.setOutputs(VanillaTypes.ITEM, outputs);
    }
}
