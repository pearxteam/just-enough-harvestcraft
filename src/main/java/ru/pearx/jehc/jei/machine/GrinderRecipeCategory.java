package ru.pearx.jehc.jei.machine;

import com.pam.harvestcraft.Reference;
import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.item.GrinderRecipes;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.reflect.FieldUtils;
import ru.pearx.jehc.JEHC;
import ru.pearx.jehc.jei.machine.MachineRecipeCategory;
import ru.pearx.jehc.jei.machine.MachineRecipeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
