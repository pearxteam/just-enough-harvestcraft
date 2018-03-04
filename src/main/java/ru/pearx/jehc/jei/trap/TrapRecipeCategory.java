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

/*
 * Created by mrAppleXZ on 19.07.17 11:06.
 */
@SideOnly(Side.CLIENT)
public abstract class TrapRecipeCategory implements IRecipeCategory<TrapRecipeWrapper>
{
    private final String uid;
    private final String unloc;
    private final IDrawable bg;

    public TrapRecipeCategory(String unloc, String uid, IGuiHelper helper, String png)
    {
        this.uid = uid;
        this.unloc = unloc;
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
        return I18n.format(unloc);
    }

    @Override
    public String getModName()
    {
        return Reference.NAME;
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
