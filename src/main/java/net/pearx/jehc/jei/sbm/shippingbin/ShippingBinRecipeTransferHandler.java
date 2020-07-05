/*
 * This file is part of Just Enough HarvestCraft.
 *
 * Just Enough HarvestCraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Just Enough HarvestCraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Just Enough HarvestCraft.  If not, see <https://www.gnu.org/licenses/>.
 */

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
