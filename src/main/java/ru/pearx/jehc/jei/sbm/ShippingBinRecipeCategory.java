package ru.pearx.jehc.jei.sbm;

import com.pam.harvestcraft.blocks.BlockRegistry;
import com.pam.harvestcraft.tileentities.ShippingBinItems;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IModRegistry;
import net.minecraft.item.ItemStack;
import ru.pearx.jehc.jei.BasicRecipeHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrAppleXZ on 20.05.17 23:01.
 */
public class ShippingBinRecipeCategory extends SBMRecipeCategory
{
    public static final String UID = "jehc.shippingbin";

    public ShippingBinRecipeCategory(IGuiHelper helper)
    {
        super("jehc.shippingbin.name", UID, helper, "shippingbin");
    }

    public static void setup(IModRegistry registry, IGuiHelper helper)
    {
        registry.addRecipeCategories(new ShippingBinRecipeCategory(helper));
        registry.addRecipeCategoryCraftingItem(new ItemStack(BlockRegistry.shippingbinItemBlock), UID);
        registry.addRecipeHandlers(new BasicRecipeHandler(ShippingBinRecipeWrapper.class, UID));
        List<ShippingBinRecipeWrapper> rec = new ArrayList<>();
        for(int i = 0; i < ShippingBinItems.getSize(); i++)
        {
            rec.add(new ShippingBinRecipeWrapper(ShippingBinItems.getData(i)));
        }
        registry.addRecipes(rec);
    }
}
