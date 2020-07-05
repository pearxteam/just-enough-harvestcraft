package net.pearx.jehc.jei.sbm.market;

import com.pam.harvestcraft.tileentities.MarketData;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MarketRecipeWrapper implements IRecipeWrapper {
    private MarketData md;

    public MarketRecipeWrapper(MarketData data) {
        md = data;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ItemStack pr = md.getCurrency().copy();
        pr.setCount(md.getPrice());
        ingredients.setInput(VanillaTypes.ITEM, pr);
        ingredients.setOutput(VanillaTypes.ITEM, md.getItem());
    }
}
