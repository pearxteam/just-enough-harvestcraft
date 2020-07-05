package net.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.ContainerPresser;
import com.pam.harvestcraft.gui.GuiPresser;
import com.pam.harvestcraft.item.PresserRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class PresserRecipeCategory extends MachineRecipeCategory {
    public PresserRecipeCategory(IGuiHelper helper) {
        super("jehc.presser", new ItemStack(BlockRegistry.presserItemBlock), "presser", PresserRecipes.class, "pressingList", helper, GuiPresser.class, ContainerPresser.class);
    }
}
