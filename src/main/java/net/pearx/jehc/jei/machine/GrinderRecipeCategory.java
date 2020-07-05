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
import com.pam.harvestcraft.gui.ContainerGrinder;
import com.pam.harvestcraft.gui.GuiGrinder;
import com.pam.harvestcraft.item.GrinderRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GrinderRecipeCategory extends MachineRecipeCategory {
    public GrinderRecipeCategory(IGuiHelper helper) {
        super("jehc.grinder", new ItemStack(BlockRegistry.grinderItemBlock), "grinder", GrinderRecipes.class, "grindingList", helper, GuiGrinder.class, ContainerGrinder.class);
    }
}
