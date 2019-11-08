package ru.pearx.jehc.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.jehc.jei.apiary.ApiaryRecipeCategory;
import ru.pearx.jehc.jei.machine.GrinderRecipeCategory;
import ru.pearx.jehc.jei.machine.PresserRecipeCategory;
import ru.pearx.jehc.jei.machine.WaterFilterCategory;
import ru.pearx.jehc.jei.sbm.MarketRecipeCategory;
import ru.pearx.jehc.jei.sbm.ShippingBinRecipeCategory;
import ru.pearx.jehc.jei.trap.GroundTrapRecipeCategory;
import ru.pearx.jehc.jei.trap.WaterTrapRecipeCategory;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by mrAppleXZ on 20.05.17 16:23.
 */
@JEIPlugin
@SideOnly(Side.CLIENT)
public class JehcPlugin implements IModPlugin {
    private List<JehcRecipeCategory<?>> categories;

    @Override
    public void registerCategories(IRecipeCategoryRegistration reg) {
        categories = new ArrayList<>();
        IGuiHelper helper = reg.getJeiHelpers().getGuiHelper();
        categories.add(new PresserRecipeCategory(helper));
        categories.add(new ShippingBinRecipeCategory(helper));
        categories.add(new MarketRecipeCategory(helper));
        categories.add(new ApiaryRecipeCategory(helper));
        categories.add(new GroundTrapRecipeCategory(helper));
        categories.add(new WaterTrapRecipeCategory(helper));
        categories.add(new GrinderRecipeCategory(helper));
        categories.add(new WaterFilterCategory(helper));
        for (JehcRecipeCategory<?> category : categories) {
            reg.addRecipeCategories(category);
        }
    }

    @Override
    public void register(IModRegistry registry) {
        for (JehcRecipeCategory<?> category : categories)
            category.setup(registry);
    }
}
