package com.jonathan.laterthanwolves.datagen;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
  public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
    super(output, LaterThanWolves.MOD_ID, exFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    blockWithItem(ModBlocks.STEEL_BLOCK);

  }

  private void blockWithItem(DeferredBlock<?> deferredBlock) {
    simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
  }
}
