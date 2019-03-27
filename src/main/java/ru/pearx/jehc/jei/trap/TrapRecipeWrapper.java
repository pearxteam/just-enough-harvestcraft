package ru.pearx.jehc.jei.trap;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Created by mrAppleXZ on 19.07.17 10:39.
 */
@SideOnly(Side.CLIENT)
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
        ingredients.setInput(VanillaTypes.ITEM, in);
        ingredients.setOutput(VanillaTypes.ITEM, out);
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
