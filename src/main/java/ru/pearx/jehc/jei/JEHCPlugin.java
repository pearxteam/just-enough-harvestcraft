package ru.pearx.jehc.jei;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
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
public class JEHCPlugin extends BlankModPlugin
{
    public static final String HC_MOD_NAME = "Pam's HarvestCraft";

    @Override
    public void register(IModRegistry registry)
    {
        PresserRecipeCategory.setup(registry, registry.getJeiHelpers().getGuiHelper());
        ShippingBinRecipeCategory.setup(registry, registry.getJeiHelpers().getGuiHelper());
        MarketRecipeCategory.setup(registry, registry.getJeiHelpers().getGuiHelper());
        ApiaryRecipeCategory.setup(registry, registry.getJeiHelpers().getGuiHelper());
        GroundTrapRecipeCategory.setup(registry, registry.getJeiHelpers().getGuiHelper());
        WaterTrapRecipeCategory.setup(registry, registry.getJeiHelpers().getGuiHelper());
    }
}
