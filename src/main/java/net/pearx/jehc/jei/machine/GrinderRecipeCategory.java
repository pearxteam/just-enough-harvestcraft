package net.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.ContainerGrinder;
import com.pam.harvestcraft.gui.GuiGrinder;
import com.pam.harvestcraft.item.GrinderRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Created by mrAppleXZ on 22.03.18 20:29.
 */
@SideOnly(Side.CLIENT)
public class GrinderRecipeCategory extends MachineRecipeCategory {
    public GrinderRecipeCategory(IGuiHelper helper) {
        super("jehc.grinder", new ItemStack(BlockRegistry.grinderItemBlock), "grinder", GrinderRecipes.class, "grindingList", helper, GuiGrinder.class, ContainerGrinder.class);
    }
}
