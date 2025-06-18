package com.jonathan.laterthanwolves.datagen;

import com.jonathan.laterthanwolves.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
  protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
    super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
  }

  @Override
  protected void generate() {
    dropSelf(ModBlocks.STEEL_BLOCK.get());
    dropSelf(ModBlocks.CHISELED_STONE.get());
    dropSelf(ModBlocks.CHIPPED_STONE.get());
    dropSelf(ModBlocks.CRACKED_STONE.get());
    dropSelf(ModBlocks.CHISELED_COBBLESTONE.get());
    dropSelf(ModBlocks.CHIPPED_COBBLESTONE.get());
    dropSelf(ModBlocks.CRACKED_COBBLESTONE.get());
    dropSelf(ModBlocks.SMOOTH_STONE.get());



  }

  protected Iterable<Block> getKnownBlocks() {
    return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
  }
}
