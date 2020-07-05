package net.pearx.jehc.jei.sbm.shippingbin;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.gui.GuiShippingBin;
import com.pam.harvestcraft.tileentities.ShippingBinItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.sbm.SBMRecipeCategory;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class ShippingBinRecipeCategory extends SBMRecipeCategory {
    public ShippingBinRecipeCategory(IGuiHelper helper) {
        super("jehc.shippingbin", new ItemStack(BlockRegistry.shippingbinItemBlock), "shippingbin", helper, GuiShippingBin.class);
    }

    @Override
    public void setupRecipes(IModRegistry registry) {
        super.setupRecipes(registry);
        registry.getRecipeTransferRegistry().addRecipeTransferHandler(new ShippingBinRecipeTransferHandler(), getUid());
        List<ShippingBinRecipeWrapper> rec = new ArrayList<>();
        for (int i = 0; i < ShippingBinItems.getSize(); i++) {
            rec.add(new ShippingBinRecipeWrapper(ShippingBinItems.getData(i)));
        }
        registry.addRecipes(rec, getUid());
    }
}
