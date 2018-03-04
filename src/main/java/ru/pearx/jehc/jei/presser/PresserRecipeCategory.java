package ru.pearx.jehc.jei.presser;

import com.pam.harvestcraft.Reference;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.PresserRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.reflect.FieldUtils;
import ru.pearx.jehc.JEHC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Created by mrAppleXZ on 20.05.17 16:08.
 */
@SideOnly(Side.CLIENT)
public class PresserRecipeCategory implements IRecipeCategory<PresserRecipeWrapper>
{
    private static final String UID = "jehc.presser";
    private final IDrawable background;

    public PresserRecipeCategory(IGuiHelper helper)
    {
        background = helper.createDrawable(new ResourceLocation("harvestcraft", "textures/gui/presser.png"), 3, 8, 170, 66);
    }

    public static void setup(IModRegistry registry)
    {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.presserItemBlock), UID);
        registry.handleRecipes(PresserRecipeWrapper.class, recipe -> recipe, UID);
        List<PresserRecipeWrapper> rec = new ArrayList<>();
        try
        {
            for (Map.Entry<ItemStack, ItemStack[]> entr : ((Map<ItemStack, ItemStack[]>)FieldUtils.readStaticField(PresserRecipes.class, "pressingList", true)).entrySet())
            {
                rec.add(new PresserRecipeWrapper(entr.getKey(), entr.getValue()));
            }
        } catch (IllegalAccessException e)
        {
            JEHC.INSTANCE.getLog().error("An IllegalAccessException occurred while setting up the Presser recipes.", e);
        }
        registry.addRecipes(rec, UID);
    }

    @Override
    public String getUid()
    {
        return UID;
    }

    @Override
    public String getTitle()
    {
        return I18n.format("jehc.pressing.name");
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, PresserRecipeWrapper recipeWrapper, IIngredients ingredients)
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

    @Override
    public String getModName()
    {
        return Reference.NAME;
    }
}
