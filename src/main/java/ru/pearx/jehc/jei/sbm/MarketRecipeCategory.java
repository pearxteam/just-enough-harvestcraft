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
public class MarketRecipeCategory extends SBMRecipeCategory {
    public MarketRecipeCategory(IGuiHelper helper) {
        super("jehc.market", new ItemStack(BlockRegistry.marketItemBlock), "market", helper);
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        List<MarketRecipeWrapper> rec = new ArrayList<>();
        for (int i = 0; i < MarketItems.getSize(); i++) {
            rec.add(new MarketRecipeWrapper(MarketItems.getData(i)));
        }
        registry.addRecipes(rec, getUid());
    }
}
