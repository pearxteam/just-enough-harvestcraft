package net.pearx.jehc.jei.sbm.market;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.GuiMarket;
import com.pam.harvestcraft.tileentities.MarketItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.sbm.SBMRecipeCategory;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class MarketRecipeCategory extends SBMRecipeCategory {
    public MarketRecipeCategory(IGuiHelper helper) {
        super("jehc.market", new ItemStack(BlockRegistry.marketItemBlock), "market", helper, GuiMarket.class);
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        super.setupRecipes(registry);
        registry.getRecipeTransferRegistry().addRecipeTransferHandler(new MarketRecipeTransferHandler(), getUid());
        List<MarketRecipeWrapper> rec = new ArrayList<>();
        for (int i = 0; i < MarketItems.getSize(); i++) {
            rec.add(new MarketRecipeWrapper(MarketItems.getData(i)));
        }
        registry.addRecipes(rec, getUid());
    }
}
