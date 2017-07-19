package ru.pearx.jehc.jei.trap;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import ru.pearx.jehc.jei.JEHCPlugin;

/*
 * Created by mrAppleXZ on 19.07.17 11:06.
 */
public abstract  class TrapRecipeCategory extends BlankRecipeCategory<TrapRecipeWrapper>
{
    private final String uid;
    private final String title;
    private final IDrawable bg;

    public TrapRecipeCategory(String unloc, String uid, IGuiHelper helper, String png)
    {
        this.uid = uid;
        title = I18n.translateToLocal(unloc);
        bg = helper.createDrawable(new ResourceLocation("jehc", "textures/gui/" + png + "_trap_small.png"), 0, 0, 81, 29, 81, 29);
    }
    @Override
    public String getUid()
    {
        return uid;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public String getModName()
    {
        return JEHCPlugin.HC_MOD_NAME;
    }

    @Override
    public IDrawable getBackground()
    {
        return bg;
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
