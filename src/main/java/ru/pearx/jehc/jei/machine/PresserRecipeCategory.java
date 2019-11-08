package ru.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.PresserRecipes;
import mezz.jei.api.IGuiHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/*
 * Created by mrAppleXZ on 20.05.17 16:08.
 */
@SideOnly(Side.CLIENT)
public class PresserRecipeCategory extends MachineRecipeCategory
{
    public PresserRecipeCategory(IGuiHelper helper)
    {
        super("jehc.presser", new ItemStack(BlockRegistry.presserItemBlock), "presser", PresserRecipes.class, "pressingList", helper);
    }
}
