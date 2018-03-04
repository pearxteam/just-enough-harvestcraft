package ru.pearx.jehc.jei.sbm;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.tileentities.MarketItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by mrAppleXZ on 20.05.17 23:51.
 */
@SideOnly(Side.CLIENT)
public class MarketRecipeCategory extends SBMRecipeCategory
{
    private static final String UID = "jehc.market";

    public MarketRecipeCategory(IGuiHelper helper)
    {
        super("jehc.market.name", UID, helper, "market");
    }

    public static void setup(IModRegistry registry)
    {
        registry.addRecipeCatalyst(new ItemStack(BlockRegistry.marketItemBlock), UID);
        registry.handleRecipes(MarketRecipeWrapper.class, recipe -> recipe, UID);
        List<MarketRecipeWrapper> rec = new ArrayList<>();
        for(int i = 0; i < MarketItems.getSize(); i++)
        {
            rec.add(new MarketRecipeWrapper(MarketItems.getData(i)));
        }
        registry.addRecipes(rec, UID);
    }
}
