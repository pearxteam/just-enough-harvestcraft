package ru.pearx.jehc.jei.trap;

import com.pam.harvestcraft.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.jehc.jei.JehcRecipeCategory;

/*
 * Created by mrAppleXZ on 19.07.17 11:06.
 */
@SideOnly(Side.CLIENT)
public abstract class TrapRecipeCategory extends JehcRecipeCategory<TrapRecipeWrapper>
{
    public TrapRecipeCategory(String uid, String unlocalizedTitle, String png, IGuiHelper help)
    {
        super(uid, unlocalizedTitle, help.createDrawable(new ResourceLocation("jehc", "textures/gui/" + png + "_trap_small.png"), 0, 0, 81, 29, 81, 29));
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, TrapRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        recipeLayout.getItemStacks().init(0, true, 22, 8);
        recipeLayout.getItemStacks().set(0, ingredients.getInputs(ItemStack.class).get(0));
        recipeLayout.getItemStacks().init(1, false, 58, 8);
        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(ItemStack.class).get(0));
    }
}
