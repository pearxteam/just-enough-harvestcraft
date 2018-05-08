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
public class JEHCPlugin implements IModPlugin
{
    private List<JehcRecipeCategory> cats;

    @Override
    public void register(IModRegistry registry)
    {
        for(JehcRecipeCategory cat : cats)
            cat.setup(registry);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration reg)
    {
        cats = new ArrayList<>();
        IGuiHelper h = reg.getJeiHelpers().getGuiHelper();
        cats.add(new PresserRecipeCategory(h));
        cats.add(new ShippingBinRecipeCategory(h));
        cats.add(new MarketRecipeCategory(h));
        cats.add(new ApiaryRecipeCategory(h));
        cats.add(new GroundTrapRecipeCategory(h));
        cats.add(new WaterTrapRecipeCategory(h));
        cats.add(new GrinderRecipeCategory(h));
        for(JehcRecipeCategory cat : cats)
        {
            reg.addRecipeCategories(cat);
        }
    }
}
