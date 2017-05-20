package ru.pearx.jehc.jei;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

/**
 * Created by mrAppleXZ on 21.05.17 0:41.
 */
public class BasicRecipeHandler<T extends IRecipeWrapper> implements IRecipeHandler<T>
{
    private Class<T> clazz;
    private String uid;

    public BasicRecipeHandler(Class<T> clazz, String uid)
    {
        this.clazz = clazz;
        this.uid = uid;
    }

    @Override
    public Class<T> getRecipeClass()
    {
        return clazz;
    }

    @Override
    public String getRecipeCategoryUid()
    {
        return uid;
    }

    @Override
    public String getRecipeCategoryUid(T recipe)
    {
        return uid;
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(T recipe)
    {
        return recipe;
    }

    @Override
    public boolean isRecipeValid(T recipe)
    {
        return true;
    }
}
