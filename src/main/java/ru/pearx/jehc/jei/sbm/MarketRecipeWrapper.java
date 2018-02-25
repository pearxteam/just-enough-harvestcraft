package ru.pearx.jehc.jei.sbm;

import com.pam.harvestcraft.tileentities.MarketData;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

/*
 * Created by mrAppleXZ on 20.05.17 23:45.
 */
public class MarketRecipeWrapper implements IRecipeWrapper
{
    private MarketData md;

    public MarketRecipeWrapper(MarketData data)
    {
        md = data;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ItemStack pr = md.getCurrency().copy();
        pr.setCount(md.getPrice());
        ingredients.setInput(ItemStack.class, pr);
        ingredients.setOutput(ItemStack.class, md.getItem());
    }
}
