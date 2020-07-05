package net.pearx.jehc.jei.machine;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.pearx.jehc.Jehc;
import net.pearx.jehc.jei.JehcRecipeCategory;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MachineRecipeCategory extends JehcRecipeCategory<MachineRecipeWrapper> {
    private Class<?> recClass;
    private String recField;
    private Class<? extends GuiContainer> guiClass;
    private Class<? extends Container> containerClass;

    public MachineRecipeCategory(String uid, ItemStack catalyst, String png, Class<?> recClass, String recField, IGuiHelper helper, Class<? extends GuiContainer> guiClass, Class<? extends Container> containerClass) {
        super(uid, catalyst, helper.drawableBuilder(new ResourceLocation("harvestcraft", "textures/gui/" + png + ".png"), 3, 8, 170, 66).build());
        this.recClass = recClass;
        this.recField = recField;
        this.guiClass = guiClass;
        this.containerClass = containerClass;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setupRecipes(IModRegistry registry) {
        registry.addRecipeClickArea(guiClass, 77, 12, 22, 6, getUid());
        registry.getRecipeTransferRegistry().addRecipeTransferHandler(containerClass, getUid(), 0, 1, 3, 36);

        List<MachineRecipeWrapper> rec = new ArrayList<>();
        try {
            for (Map.Entry<ItemStack, ItemStack[]> entr : ((Map<ItemStack, ItemStack[]>) FieldUtils.readStaticField(recClass, recField, true)).entrySet()) {
                rec.add(new MachineRecipeWrapper(entr.getKey(), entr.getValue()));
            }
        }
        catch (IllegalAccessException e) {
            Jehc.INSTANCE.getLog().error("An IllegalAccessException occurred while setting up the " + recClass.getSimpleName() + " recipes.", e);
        }
        registry.addRecipes(rec, getUid());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, MachineRecipeWrapper recipeWrapper, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0, true, 76, 14);
        recipeLayout.getItemStacks().set(0, ingredients.getInputs(VanillaTypes.ITEM).get(0));
        recipeLayout.getItemStacks().init(1, false, 58, 45);
        recipeLayout.getItemStacks().set(1, ingredients.getOutputs(VanillaTypes.ITEM).get(0));
        if (ingredients.getOutputs(VanillaTypes.ITEM).size() == 2) {
            recipeLayout.getItemStacks().init(2, false, 94, 45);
            recipeLayout.getItemStacks().set(2, ingredients.getOutputs(VanillaTypes.ITEM).get(1));
        }
    }
}
