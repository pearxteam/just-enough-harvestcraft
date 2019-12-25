package net.pearx.jehc.jei.sbm.market;

import com.pam.harvestcraft.gui.ContainerMarket;
import com.pam.harvestcraft.gui.GuiMarket;
import com.pam.harvestcraft.tileentities.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pearx.jehc.jei.sbm.SBMRecipeTransferHandler;
import org.apache.commons.lang3.tuple.Pair;

@SideOnly(Side.CLIENT)
public class MarketRecipeTransferHandler extends SBMRecipeTransferHandler<ContainerMarket, GuiMarket, TileEntityMarket> {
    public MarketRecipeTransferHandler() {
        super(ContainerMarket.class, GuiMarket.class, "tileEntityMarket");
    }

    @Override
    public void setBrowsingInfo(TileEntityMarket tileEntity, int itemNum) {
        tileEntity.setBrowsingInfo(itemNum);
    }

    @Override
    public int getRegistrySize() {
        return MarketItems.getSize();
    }

    @Override
    public Pair<ItemStack, ItemStack> getRecipe(int itemNum) {
        MarketData dat = MarketItems.getData(itemNum);
        ItemStack datIn = dat.getCurrency().copy();
        datIn.setCount(dat.getPrice());
        ItemStack datOut = dat.getItem();
        return Pair.of(datIn, datOut);
    }
}
