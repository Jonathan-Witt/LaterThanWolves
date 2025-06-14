package com.jonathan.laterthanwolves.datagen;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
  public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
    super(output, LaterThanWolves.MOD_ID, existingFileHelper);
  }

  @Override
  protected void registerModels() {
    basicItem(ModItems.STEEL_INGOT.get());
    basicItem(ModItems.COPPER_AXE.get());
    basicItem(ModItems.COPPER_HOE.get());
    basicItem(ModItems.COPPER_PICKAXE.get());
    basicItem(ModItems.COPPER_SHOVEL.get());
    basicItem(ModItems.COPPER_SWORD.get());
    basicItem(ModItems.DIAMOND_CHISEL.get());
  }
}