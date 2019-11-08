package net.pearx.jehc.jei;

import com.pam.harvestcraft.Reference;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Created by mrAppleXZ on 22.03.18 20:48.
 */
@SideOnly(Side.CLIENT)
public abstract class JehcRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T> {
    private String uid;
    private IDrawable background;
    private ItemStack catalyst;

    public JehcRecipeCategory(String uid, ItemStack catalyst, IDrawable background) {
        this.uid = uid;
        this.catalyst = catalyst;
        this.background = background;
    }

    public final void setup(IModRegistry reg) {
        reg.addRecipeCatalyst(catalyst, getUid());
        setupRecipes(reg);
    }

    public abstract void setupRecipes(IModRegistry reg);

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public String getTitle() {
        return I18n.format(catalyst.getTranslationKey() + ".name");
    }

    @Override
    public String getModName() {
        return Reference.NAME;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }
}
