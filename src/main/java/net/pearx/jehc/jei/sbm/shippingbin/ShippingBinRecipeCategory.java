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

package net.pearx.jehc.jei.sbm.shippingbin;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.GuiShippingBin;
import com.pam.harvestcraft.tileentities.ShippingBinItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.sbm.SBMRecipeCategory;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class ShippingBinRecipeCategory extends SBMRecipeCategory {
    public ShippingBinRecipeCategory(IGuiHelper helper) {
        super("jehc.shippingbin", new ItemStack(BlockRegistry.shippingbinItemBlock), "shippingbin", helper, GuiShippingBin.class);
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        super.setupRecipes(registry);
        registry.getRecipeTransferRegistry().addRecipeTransferHandler(new ShippingBinRecipeTransferHandler(), getUid());
        List<ShippingBinRecipeWrapper> rec = new ArrayList<>();
        for (int i = 0; i < ShippingBinItems.getSize(); i++) {
            rec.add(new ShippingBinRecipeWrapper(ShippingBinItems.getData(i)));
        }
        registry.addRecipes(rec, getUid());
    }
}
