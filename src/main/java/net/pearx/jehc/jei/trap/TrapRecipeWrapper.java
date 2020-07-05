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

package net.pearx.jehc.jei.trap;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class TrapRecipeWrapper implements IRecipeWrapper {
    private final ItemStack in;
    private final ItemStack out;

    public TrapRecipeWrapper(ItemStack in, ItemStack out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(VanillaTypes.ITEM, in);
        ingredients.setOutput(VanillaTypes.ITEM, out);
    }

    public static class Ground extends TrapRecipeWrapper {
        public Ground(ItemStack in, ItemStack out) {
            super(in, out);
        }
    }

    public static class Water extends TrapRecipeWrapper {
        public Water(ItemStack in, ItemStack out) {
            super(in, out);
        }
    }
}
