package ru.pearx.jehc.jei.trap;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.ItemRegistry;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

/*
 * Created by mrAppleXZ on 19.07.17 11:34.
 */
@SideOnly(Side.CLIENT)
public class GroundTrapRecipeCategory extends TrapRecipeCategory
{
    private static final String UID = "jehc.ground_trap";

    public GroundTrapRecipeCategory(IGuiHelper helper)
    {
        super("jehc.ground_trap.name", UID, helper, "ground");
    }

    public static void setup(IModRegistry registry)
    {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.groundtrapItemBlock), UID);
        registry.handleRecipes(TrapRecipeWrapper.Ground.class, recipe -> recipe, UID);
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
        ), UID);
    }
}
