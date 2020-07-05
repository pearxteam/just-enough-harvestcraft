package net.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.ContainerWaterFilter;
import com.pam.harvestcraft.gui.GuiWaterFilter;
import com.pam.harvestcraft.item.WaterFilterRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;

public class WaterFilterCategory extends MachineRecipeCategory {
    public WaterFilterCategory(IGuiHelper helper) {
        super("jehc.waterfilter", new ItemStack(BlockRegistry.waterfilterItemBlock), "waterfilter", WaterFilterRecipes.class, "waterfilterList", helper, GuiWaterFilter.class, ContainerWaterFilter.class);
    }
}
