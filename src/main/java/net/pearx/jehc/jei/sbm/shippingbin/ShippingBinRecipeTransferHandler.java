package net.pearx.jehc.jei.sbm.shippingbin;

import com.pam.harvestcraft.gui.ContainerShippingBin;
import com.pam.harvestcraft.gui.GuiShippingBin;
import com.pam.harvestcraft.tileentities.ShippingBinData;
import com.pam.harvestcraft.tileentities.ShippingBinItems;
import com.pam.harvestcraft.tileentities.TileEntityShippingBin;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.sbm.SBMRecipeTransferHandler;
import org.apache.commons.lang3.tuple.Pair;

@SideOnly(Side.CLIENT)
public class ShippingBinRecipeTransferHandler extends SBMRecipeTransferHandler<ContainerShippingBin, GuiShippingBin, TileEntityShippingBin> {
    public ShippingBinRecipeTransferHandler() {
        super(ContainerShippingBin.class, GuiShippingBin.class, "tileEntityShippingBin");
    }

    @Override
    public void setBrowsingInfo(TileEntityShippingBin tileEntity, int itemNum) {
        tileEntity.setBrowsingInfo(itemNum);
    }

    @Override
    public int getRegistrySize() {
        return ShippingBinItems.getSize();
    }

    @Override
    public Pair<ItemStack, ItemStack> getRecipe(int itemNum) {
        ShippingBinData dat = ShippingBinItems.getData(itemNum);
        ItemStack datIn = dat.getCurrency().copy();
        datIn.setCount(dat.getPrice());
        ItemStack datOut = dat.getItem();
        return Pair.of(datIn, datOut);
    }
}
