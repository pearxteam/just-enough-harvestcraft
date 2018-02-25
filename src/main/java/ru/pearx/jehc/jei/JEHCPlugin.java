package ru.pearx.jehc.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import ru.pearx.jehc.jei.apiary.ApiaryRecipeCategory;
import ru.pearx.jehc.jei.presser.PresserRecipeCategory;
import ru.pearx.jehc.jei.sbm.MarketRecipeCategory;
import ru.pearx.jehc.jei.sbm.ShippingBinRecipeCategory;
import ru.pearx.jehc.jei.trap.GroundTrapRecipeCategory;
import ru.pearx.jehc.jei.trap.WaterTrapRecipeCategory;

/*
 * Created by mrAppleXZ on 20.05.17 16:23.
 */
@JEIPlugin
public class JEHCPlugin implements IModPlugin
{
    @Override
    public void register(IModRegistry registry)
    {
        PresserRecipeCategory.setup(registry);
        ShippingBinRecipeCategory.setup(registry);
        MarketRecipeCategory.setup(registry);
        ApiaryRecipeCategory.setup(registry);
        GroundTrapRecipeCategory.setup(registry);
        WaterTrapRecipeCategory.setup(registry);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration reg)
    {
        reg.addRecipeCategories(new PresserRecipeCategory(reg.getJeiHelpers().getGuiHelper()));
        reg.addRecipeCategories(new ShippingBinRecipeCategory(reg.getJeiHelpers().getGuiHelper()));
        reg.addRecipeCategories(new MarketRecipeCategory(reg.getJeiHelpers().getGuiHelper()));
        reg.addRecipeCategories(new ApiaryRecipeCategory(reg.getJeiHelpers().getGuiHelper()));
        reg.addRecipeCategories(new GroundTrapRecipeCategory(reg.getJeiHelpers().getGuiHelper()));
        reg.addRecipeCategories(new WaterTrapRecipeCategory(reg.getJeiHelpers().getGuiHelper()));
    }
}
