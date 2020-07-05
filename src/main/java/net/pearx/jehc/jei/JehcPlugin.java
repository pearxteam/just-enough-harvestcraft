/*
 * This file is part of Just Enough HarvestCraft.
 *
 * Just Enough HarvestCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Just Enough HarvestCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Just Enough HarvestCraft.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.pearx.jehc.jei;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.apiary.ApiaryRecipeCategory;
import net.pearx.jehc.jei.machine.GrinderRecipeCategory;
import net.pearx.jehc.jei.machine.PresserRecipeCategory;
import net.pearx.jehc.jei.machine.WaterFilterCategory;
import net.pearx.jehc.jei.sbm.market.MarketRecipeCategory;
import net.pearx.jehc.jei.sbm.shippingbin.ShippingBinRecipeCategory;
import net.pearx.jehc.jei.trap.GroundTrapRecipeCategory;
import net.pearx.jehc.jei.trap.WaterTrapRecipeCategory;

import java.util.ArrayList;
import java.util.List;

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
