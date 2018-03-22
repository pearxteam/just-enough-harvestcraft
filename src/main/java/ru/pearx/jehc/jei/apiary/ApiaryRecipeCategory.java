package ru.pearx.jehc.jei.apiary;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.ItemRegistry;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.jehc.jei.JehcRecipeCategory;

import java.util.Arrays;

/*
 * Created by mrAppleXZ on 21.05.17 11:51.
 */
@SideOnly(Side.CLIENT)
public class ApiaryRecipeCategory extends JehcRecipeCategory<ApiaryRecipeWrapper>
{
    public ApiaryRecipeCategory(IGuiHelper help)
    {
        super("jehc.apiary", "jehc.apiary.name", help.createDrawable(new ResourceLocation("harvestcraft", "textures/gui/apiary.png"), 3, 8, 170, 66));
    }

    @Override
    public void setup(IModRegistry registry)
    {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.apiaryItemBlock), getUid());
        registry.addRecipes(Arrays.asList(
                new ApiaryRecipeWrapper(new ItemStack(ItemRegistry.queenbeeItem), new ItemStack(ItemRegistry.waxcombItem), 50),
                new ApiaryRecipeWrapper(new ItemStack(ItemRegistry.queenbeeItem), new ItemStack(ItemRegistry.honeycombItem), 45),
                new ApiaryRecipeWrapper(new ItemStack(ItemRegistry.queenbeeItem), new ItemStack(ItemRegistry.grubItem), 5)
                ), getUid());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ApiaryRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        recipeLayout.getItemStacks().init(0, true, 22, 26);
        recipeLayout.getItemStacks().set(0, ingredients.getInputs(ItemStack.class).get(0));
        recipeLayout.getItemStacks().init(1, false, 58, 8);
        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(ItemStack.class).get(0));
    }
}
