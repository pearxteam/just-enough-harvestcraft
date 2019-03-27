package ru.pearx.jehc.jei.trap;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
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
        super(uid, unlocalizedTitle, help.drawableBuilder(new ResourceLocation("jehc", "textures/gui/" + png + "_trap_small.png"), 0, 0, 81, 29).setTextureSize(81, 29).build());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, TrapRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        recipeLayout.getItemStacks().init(0, true, 22, 8);
        recipeLayout.getItemStacks().set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        recipeLayout.getItemStacks().init(1, false, 58, 8);
        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
    }
}
