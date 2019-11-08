package ru.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.WaterFilterRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;

/*
 * Created by mrAppleXZ on 05.07.18 2:57
 */
public class WaterFilterCategory extends MachineRecipeCategory {
    public WaterFilterCategory(IGuiHelper helper) {
        super("jehc.waterfilter", new ItemStack(BlockRegistry.waterfilterItemBlock), "waterfilter", WaterFilterRecipes.class, "waterfilterList", helper);
    }
}
