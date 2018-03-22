package ru.pearx.jehc.jei.machine;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.reflect.FieldUtils;
import ru.pearx.jehc.JEHC;
import ru.pearx.jehc.jei.JehcRecipeCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Created by mrAppleXZ on 22.03.18 20:46.
 */
public class MachineRecipeCategory extends JehcRecipeCategory<MachineRecipeWrapper>
{
    private Class recClass;
    private String recField;

    public MachineRecipeCategory(String uid, String unlocalizedTitle, String png, Class recClass, String recField, IGuiHelper helper)
    {
        super(uid, unlocalizedTitle, helper.createDrawable(new ResourceLocation("harvestcraft", "textures/gui/" + png + ".png"), 3, 8, 170, 66));
        this.recClass = recClass;
        this.recField = recField;
    }

    @Override
    public void setup(IModRegistry registry)
    {
        List<MachineRecipeWrapper> rec = new ArrayList<>();
        try
        {
            for (Map.Entry<ItemStack, ItemStack[]> entr : ((Map<ItemStack, ItemStack[]>)FieldUtils.readStaticField(recClass, recField, true)).entrySet())
            {
                rec.add(new MachineRecipeWrapper(entr.getKey(), entr.getValue()));
            }
        } catch (IllegalAccessException e)
        {
            JEHC.INSTANCE.getLog().error("An IllegalAccessException occurred while setting up the " + recClass.getSimpleName() + " recipes.", e);
        }
        registry.addRecipes(rec, getUid());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, MachineRecipeWrapper recipeWrapper, IIngredients ingredients)
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
