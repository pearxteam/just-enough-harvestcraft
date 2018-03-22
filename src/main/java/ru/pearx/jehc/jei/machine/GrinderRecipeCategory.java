package ru.pearx.jehc.jei.machine;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.GrinderRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.pearx.jehc.jei.machine.MachineRecipeCategory;

/*
 * Created by mrAppleXZ on 22.03.18 20:29.
 */
@SideOnly(Side.CLIENT)
public class GrinderRecipeCategory extends MachineRecipeCategory
{
    public GrinderRecipeCategory(IGuiHelper helper)
    {
        super("jehc.grinder", "jehc.grinder.name", "grinder", GrinderRecipes.class, "grindingList", helper);
    }

    @Override
    public void setup(IModRegistry registry)
    {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.grinderItemBlock), getUid());
        super.setup(registry);
    }
}
