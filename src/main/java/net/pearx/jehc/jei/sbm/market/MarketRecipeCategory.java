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

package net.pearx.jehc.jei.sbm.market;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.GuiMarket;
import com.pam.harvestcraft.tileentities.MarketItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.sbm.SBMRecipeCategory;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class MarketRecipeCategory extends SBMRecipeCategory {
    public MarketRecipeCategory(IGuiHelper helper) {
        super("jehc.market", new ItemStack(BlockRegistry.marketItemBlock), "market", helper, GuiMarket.class);
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        super.setupRecipes(registry);
        registry.getRecipeTransferRegistry().addRecipeTransferHandler(new MarketRecipeTransferHandler(), getUid());
        List<MarketRecipeWrapper> rec = new ArrayList<>();
        for (int i = 0; i < MarketItems.getSize(); i++) {
            rec.add(new MarketRecipeWrapper(MarketItems.getData(i)));
        }
        registry.addRecipes(rec, getUid());
    }
}
