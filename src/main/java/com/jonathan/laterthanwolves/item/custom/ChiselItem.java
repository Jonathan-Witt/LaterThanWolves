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
  public static final Map<BlockState, BlockState> CHISEL_BLOCK =
      Map.of(
          Blocks.DEEPSLATE.defaultBlockState(), Blocks.COBBLED_DEEPSLATE.defaultBlockState(),
          Blocks.COBBLED_DEEPSLATE.defaultBlockState(), Blocks.STONE.defaultBlockState(),
          Blocks.STONE.defaultBlockState(), Blocks.COBBLESTONE.defaultBlockState(),
          Blocks.COBBLESTONE.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()
      );

  public static final Map<BlockState, ItemStack> CHISEL_ITEM =
      Map.of(
          Blocks.DEEPSLATE.defaultBlockState(), new ItemStack(Items.GRAVEL),
          Blocks.COBBLED_DEEPSLATE.defaultBlockState(), new ItemStack(Items.GRAVEL),
          Blocks.STONE.defaultBlockState(), new ItemStack(Items.GRAVEL),
          Blocks.COBBLESTONE.defaultBlockState(), new ItemStack(Items.GRAVEL)
      );

  public ChiselItem(Tier tier, Properties properties) {
    super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
  }

//  @Override
//  public boolean mineBlock(ItemStack stack, Level level, BlockState brokenBlock, BlockPos pos, LivingEntity miningEntity) {
//    Tool tool = stack.get(DataComponents.TOOL);
//    if (!level.isClientSide && brokenBlock.getDestroySpeed(level, pos) != 0.0F && tool.damagePerBlock() > 0) {
//      stack.hurtAndBreak(tool.damagePerBlock(), miningEntity, EquipmentSlot.MAINHAND);
//      if(CHISEL_BLOCK.containsKey(brokenBlock)) {
//        level.setBlockAndUpdate(pos, CHISEL_BLOCK.get(brokenBlock));
//        Block.popResource(level, pos, CHISEL_ITEM.get(brokenBlock));
//      }
//    }
//    return false;
//  }
}
