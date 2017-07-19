package ru.pearx.jehc.jei.trap;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.ItemRegistry;
import com.pam.harvestcraft.tileentities.MarketItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import ru.pearx.jehc.jei.sbm.MarketRecipeCategory;
import ru.pearx.jehc.jei.sbm.MarketRecipeWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Created by mrAppleXZ on 19.07.17 11:34.
 */
public class GroundTrapRecipeCategory extends TrapRecipeCategory
{
    private static final String UID = "jehc.ground_trap";

    public GroundTrapRecipeCategory(IGuiHelper helper)
    {
        super("jehc.ground_trap.name", UID, helper, "ground");
    }

    public static void setup(IModRegistry registry, IGuiHelper helper)
    {
        registry.addRecipeCategories(new GroundTrapRecipeCategory(helper));
        registry.addRecipeCategoryCraftingItem(new ItemStack(BlockRegistry.groundtrapItemBlock), UID);
        registry.handleRecipes(TrapRecipeWrapper.Ground.class, recipe -> recipe, UID);
        registry.addRecipes(Arrays.asList(
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.grainbaitItem), new ItemStack(ItemRegistry.turkeyrawItem, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.grainbaitItem), new ItemStack(Items.BEEF, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.grainbaitItem), new ItemStack(Items.CHICKEN, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.grainbaitItem), new ItemStack(Items.LEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.grainbaitItem), new ItemStack(Items.FEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.grainbaitItem), new ItemStack(Items.EGG, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.grainbaitItem), new ItemStack(Items.BONE, 1, 0)),

                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.RABBIT, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.LEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.FEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.EGG, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.BONE, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.RABBIT_FOOT, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.RABBIT_HIDE, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.fruitbaitItem), new ItemStack(Items.CHICKEN, 1, 0)),

                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(ItemRegistry.venisonrawItem, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(Items.MUTTON, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(Items.PORKCHOP, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(Items.LEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(Items.FEATHER, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(Items.EGG, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(Items.BONE, 1, 0)),
                new TrapRecipeWrapper.Ground(new ItemStack(ItemRegistry.veggiebaitItem), new ItemStack(Items.CHICKEN, 1, 0))
        ), UID);
    }
}
