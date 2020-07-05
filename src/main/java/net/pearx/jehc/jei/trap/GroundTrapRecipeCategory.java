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

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.ContainerGroundTrap;
import com.pam.harvestcraft.gui.GuiGroundTrap;
import com.pam.harvestcraft.item.ItemRegistry;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class GroundTrapRecipeCategory extends TrapRecipeCategory {
    public GroundTrapRecipeCategory(IGuiHelper helper) {
        super("jehc.ground_trap", new ItemStack(BlockRegistry.groundtrapItemBlock), "ground", helper, GuiGroundTrap.class, ContainerGroundTrap.class);
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        super.setupRecipes(registry);
        ItemStack grain = new ItemStack(ItemRegistry.grainbaitItem);
        ItemStack fruit = new ItemStack(ItemRegistry.fruitbaitItem);
        ItemStack veggie = new ItemStack(ItemRegistry.veggiebaitItem);
        registry.addRecipes(Arrays.asList(
                new TrapRecipeWrapper.Ground(grain, new ItemStack(ItemRegistry.turkeyrawItem, 1, 0)),
                new TrapRecipeWrapper.Ground(grain, new ItemStack(Items.BEEF, 1, 0)),
                new TrapRecipeWrapper.Ground(grain, new ItemStack(Items.CHICKEN, 1, 0)),
                new TrapRecipeWrapper.Ground(grain, new ItemStack(Items.LEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(grain, new ItemStack(Items.FEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(grain, new ItemStack(Items.EGG, 1, 0)),
                new TrapRecipeWrapper.Ground(grain, new ItemStack(Items.BONE, 1, 0)),
                new TrapRecipeWrapper.Ground(grain, new ItemStack(ItemRegistry.duckrawItem, 1, 0)),

                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.RABBIT, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.LEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.FEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.EGG, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.BONE, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.RABBIT_FOOT, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.RABBIT_HIDE, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(Items.CHICKEN, 1, 0)),
                new TrapRecipeWrapper.Ground(fruit, new ItemStack(ItemRegistry.duckrawItem, 1, 0)),

                new TrapRecipeWrapper.Ground(veggie, new ItemStack(ItemRegistry.venisonrawItem, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(Items.MUTTON, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(Items.PORKCHOP, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(Items.LEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(Items.FEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(Items.EGG, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(Items.BONE, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(Items.CHICKEN, 1, 0)),
                new TrapRecipeWrapper.Ground(veggie, new ItemStack(ItemRegistry.duckrawItem, 1, 0))
        ), getUid());
    }
}
