package ru.pearx.jehc.jei;

import mezz.jei.api.BlankModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;

/**
 * Created by mrAppleXZ on 20.05.17 16:23.
 */
@JEIPlugin
public class JEHCPlugin extends BlankModPlugin
{
    @Override
    public void register(IModRegistry registry)
    {
        PresserRecipeCategory.register(registry, registry.getJeiHelpers().getGuiHelper());
    }
}
