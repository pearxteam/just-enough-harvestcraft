package ru.pearx.jehc.jei.sbm;

import com.pam.harvestcraft.tileentities.ShippingBinData;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

/*
 * Created by mrAppleXZ on 20.05.17 22:57.
 */
public class ShippingBinRecipeWrapper extends BlankRecipeWrapper
{
    public ShippingBinData sbd;

    public ShippingBinRecipeWrapper(ShippingBinData data)
    {
        this.sbd = data;
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ItemStack pr = sbd.getCurrency().copy();
        pr.setCount(sbd.getPrice());
        ingredients.setInput(ItemStack.class, pr);
        ingredients.setOutput(ItemStack.class, sbd.getItem());
    }
}
