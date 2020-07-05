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

package net.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.ContainerWaterFilter;
import com.pam.harvestcraft.gui.GuiWaterFilter;
import com.pam.harvestcraft.item.WaterFilterRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;

public class WaterFilterCategory extends MachineRecipeCategory {
    public WaterFilterCategory(IGuiHelper helper) {
        super("jehc.waterfilter", new ItemStack(BlockRegistry.waterfilterItemBlock), "waterfilter", WaterFilterRecipes.class, "waterfilterList", helper, GuiWaterFilter.class, ContainerWaterFilter.class);
    }
}
