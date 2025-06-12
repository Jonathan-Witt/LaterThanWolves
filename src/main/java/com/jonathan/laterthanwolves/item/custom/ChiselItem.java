package com.jonathan.laterthanwolves.item.custom;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ChiselItem extends DiggerItem {
  public static final Map<Block, BlockState> CHISEL_BLOCK =
      Map.of(
          Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE.defaultBlockState(),
          Blocks.COBBLED_DEEPSLATE, Blocks.STONE.defaultBlockState(),
          Blocks.STONE, Blocks.COBBLESTONE.defaultBlockState(),
          Blocks.COBBLESTONE, Blocks.GRAVEL.defaultBlockState()
      );

  public static final Map<Block, ItemStack> CHISEL_ITEM =
      Map.of(
          Blocks.DEEPSLATE, new ItemStack(Items.GRAVEL),
          Blocks.COBBLED_DEEPSLATE, new ItemStack(Items.GRAVEL),
          Blocks.STONE, new ItemStack(Items.GRAVEL),
          Blocks.COBBLESTONE, new ItemStack(Items.GRAVEL)
      );

  public ChiselItem(Tier tier, Properties properties) {
    super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
  }
}
