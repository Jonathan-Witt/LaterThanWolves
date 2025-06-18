package com.jonathan.laterthanwolves.block;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
  public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(
      LaterThanWolves.MOD_ID
  );

  public static final DeferredBlock<Block> STEEL_BLOCK = registerBlock("steel_block",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

  public static final DeferredBlock<Block> CHISELED_STONE = registerBlock("chiseled_stone",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

  public static final DeferredBlock<Block> CHIPPED_STONE = registerBlock("chipped_stone",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

  public static final DeferredBlock<Block> CRACKED_STONE = registerBlock("cracked_stone",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

  public static final DeferredBlock<Block> CHISELED_COBBLESTONE = registerBlock("chiseled_cobblestone",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

  public static final DeferredBlock<Block> CHIPPED_COBBLESTONE = registerBlock("chipped_cobblestone",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

  public static final DeferredBlock<Block> CRACKED_COBBLESTONE = registerBlock("cracked_cobblestone",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

  public static final DeferredBlock<Block> SMOOTH_STONE = registerBlock("smooth_stone",
      () -> new Block(BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

  private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
    DeferredBlock<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
    ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
