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
import com.pam.harvestcraft.gui.ContainerPresser;
import com.pam.harvestcraft.gui.GuiPresser;
import com.pam.harvestcraft.item.PresserRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PresserRecipeCategory extends MachineRecipeCategory {
    public PresserRecipeCategory(IGuiHelper helper) {
        super("jehc.presser", new ItemStack(BlockRegistry.presserItemBlock), "presser", PresserRecipes.class, "pressingList", helper, GuiPresser.class, ContainerPresser.class);
    }
}
