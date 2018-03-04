package ru.pearx.jehc.jei.sbm;

import com.pam.harvestcraft.tileentities.ShippingBinData;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Created by mrAppleXZ on 20.05.17 22:57.
 */
@SideOnly(Side.CLIENT)
public class ShippingBinRecipeWrapper implements IRecipeWrapper
{
    private ShippingBinData sbd;

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
