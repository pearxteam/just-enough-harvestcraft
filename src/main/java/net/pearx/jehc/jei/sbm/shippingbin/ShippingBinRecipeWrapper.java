package net.pearx.jehc.jei.sbm.shippingbin;

import com.pam.harvestcraft.tileentities.ShippingBinData;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ShippingBinRecipeWrapper implements IRecipeWrapper {
    private ShippingBinData data;

    public ShippingBinRecipeWrapper(ShippingBinData data) {
        this.data = data;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ItemStack pr = data.getCurrency().copy();
        pr.setCount(data.getPrice());
        ingredients.setInput(VanillaTypes.ITEM, pr);
        ingredients.setOutput(VanillaTypes.ITEM, data.getItem());
    }
}
