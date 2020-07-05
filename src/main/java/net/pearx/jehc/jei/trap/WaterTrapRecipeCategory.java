package net.pearx.jehc.jei.trap;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.ContainerWaterTrap;
import com.pam.harvestcraft.gui.GuiWaterTrap;
import com.pam.harvestcraft.item.ItemRegistry;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class WaterTrapRecipeCategory extends TrapRecipeCategory {
    public WaterTrapRecipeCategory(IGuiHelper helper) {
        super("jehc.water_trap", new ItemStack(BlockRegistry.watertrapItemBlock), "water", helper, GuiWaterTrap.class, ContainerWaterTrap.class);
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        super.setupRecipes(registry);
        ItemStack fishBait = new ItemStack(ItemRegistry.fishtrapbaitItem);
        registry.addRecipes(Arrays.asList(
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(Items.FISH, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(Items.FISH, 1, 1)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(Items.FISH, 1, 2)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(Items.FISH, 1, 3)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.anchovyrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.bassrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.carprawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.catfishrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.charrrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.clamrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.crabrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.crayfishrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.eelrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.frograwItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.grouperrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.herringrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.jellyfishrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.mudfishrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.octopusrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.perchrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.scalloprawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.shrimprawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.snailrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.snapperrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.tilapiarawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.troutrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.tunarawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.turtlerawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.walleyerawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.greenheartfishItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.duckrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.musselrawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.sardinerawItem, 1, 0)),
                new TrapRecipeWrapper.Water(fishBait, new ItemStack(ItemRegistry.oysterrawItem, 1, 0))
        ), getUid());
    }
}
