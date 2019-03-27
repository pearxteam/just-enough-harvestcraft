package ru.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.WaterFilterRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;

/*
 * Created by mrAppleXZ on 05.07.18 2:57
 */
public class WaterFilterCategory extends MachineRecipeCategory
{
    public WaterFilterCategory(IGuiHelper helper)
    {
        super("jehc.waterfilter", "jehc.waterfilter.name", "waterfilter", WaterFilterRecipes.class, "waterfilterList", helper);
    }

    @Override
    public void setup(IModRegistry registry)
    {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.waterfilterItemBlock), getUid());
        super.setup(registry);
    }
}
