package ru.pearx.jehc.jei;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.PresserRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mrAppleXZ on 20.05.17 16:08.
 */
public class PresserRecipeCategory extends BlankRecipeCategory<BlankRecipeWrapper>
{
    public static final String UID = "jehc.presser";
    private final String title;
    private final IDrawable background;

    public PresserRecipeCategory(IGuiHelper helper)
    {
        title = I18n.translateToLocal("jehc.pressing.name");
        background = helper.createDrawable(new ResourceLocation("harvestcraft", "textures/gui/presser.png"), 3, 8, 170, 66);
    }

    public static void setup(IModRegistry registry, IGuiHelper guiHelper)
    {
        registry.addRecipeCategories(new PresserRecipeCategory(guiHelper));
        registry.addRecipeCategoryCraftingItem(new ItemStack(BlockRegistry.presserItemBlock), UID);
        registry.addRecipeHandlers(new BasicRecipeHandler(PresserRecipeWrapper.class, UID));
        List<PresserRecipeWrapper> rec = new ArrayList<>();
        try
        {
            for (Map.Entry<ItemStack, ItemStack[]> entr : ((Map<ItemStack, ItemStack[]>)FieldUtils.readStaticField(PresserRecipes.class, "pressingList", true)).entrySet())
            {
                rec.add(new PresserRecipeWrapper(entr.getKey(), entr.getValue()));
            }
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        registry.addRecipes(rec);
    }

    @Override
    public String getUid()
    {
        return UID;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, BlankRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        recipeLayout.getItemStacks().init(0, true, 76, 14);
        recipeLayout.getItemStacks().set(0, ingredients.getInputs(ItemStack.class).get(0));
        recipeLayout.getItemStacks().init(1, false, 58, 45);
        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(ItemStack.class).get(0));
        if(ingredients.getOutputs(ItemStack.class).size() == 2)
        {
            recipeLayout.getItemStacks().init(2, false, 94, 45);
            recipeLayout.getItemStacks().set(2, ingredients.getOutputs(ItemStack.class).get(1));
        }
    }
}
