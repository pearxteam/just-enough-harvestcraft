package ru.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.PresserRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
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
        super("jehc.presser", "jehc.pressing.name", "presser", PresserRecipes.class, "pressingList", helper);
    }

    @Override
    public void setup(IModRegistry registry)
    {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.presserItemBlock), getUid());
        super.setup(registry);
    }
}
