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
  public static final Map<Block, Block> CHISEL_BLOCK =
      Map.of(
          Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE,
          Blocks.COBBLED_DEEPSLATE, Blocks.STONE,
          Blocks.STONE, Blocks.COBBLESTONE,
          Blocks.COBBLESTONE, Blocks.GRAVEL
      );

  public static final Map<Block, Item> CHISEL_ITEM =
      Map.of(
          Blocks.DEEPSLATE, Items.GRAVEL,
          Blocks.COBBLED_DEEPSLATE, Items.GRAVEL,
          Blocks.STONE, Items.GRAVEL,
          Blocks.COBBLESTONE, Items.GRAVEL
      );

  public ChiselItem(Tier tier, Properties properties) {
    super(tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
  }

  @Override
  public boolean mineBlock(ItemStack stack, Level level, BlockState brokenBlock, BlockPos pos, LivingEntity miningEntity) {
    Tool tool = stack.get(DataComponents.TOOL);
    if (!level.isClientSide && brokenBlock.getDestroySpeed(level, pos) != 0.0F && tool.damagePerBlock() > 0) {
      stack.hurtAndBreak(tool.damagePerBlock(), miningEntity, EquipmentSlot.MAINHAND);
      if(CHISEL_BLOCK.containsKey(brokenBlock)) {
        level.setBlockAndUpdate(pos, CHISEL_BLOCK.get(brokenBlock).defaultBlockState());
        Block.popResource(level, pos, new ItemStack(CHISEL_ITEM.get(brokenBlock)));
      }
    }
    return false;
  }
}
