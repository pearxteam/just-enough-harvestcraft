package ru.pearx.jehc.jei;

import com.pam.harvestcraft.Reference;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Created by mrAppleXZ on 22.03.18 20:48.
 */
@SideOnly(Side.CLIENT)
public abstract class JehcRecipeCategory<T extends IRecipeWrapper> implements IRecipeCategory<T>
{
    private String uid;
    private String unlocalizedTitle;
    private IDrawable background;

    public JehcRecipeCategory(String uid, String unlocalizedTitle, IDrawable background)
    {
        this.uid = uid;
        this.unlocalizedTitle = unlocalizedTitle;
        this.background = background;
    }

    public abstract void setup(IModRegistry reg);

    @Override
    public String getUid()
    {
        return uid;
    }

    @Override
    public String getTitle()
    {
        return I18n.format(unlocalizedTitle);
    }

    @Override
    public String getModName()
    {
        return Reference.NAME;
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }
}
