package com.jonathan.laterthanwolves.event;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.item.custom.ChiselItem;
import net.minecraft.FieldsAreNonnullByDefault;
import net.minecraft.client.multiplayer.chat.LoggedChatMessage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.Map;
import java.util.Objects;

@EventBusSubscriber(modid = LaterThanWolves.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
@FieldsAreNonnullByDefault
public class ModEvents {

  public static Direction getTargetedFace(Player player, Level level) {
    Vec3 eyePos = player.getEyePosition();
    Vec3 viewVector = player.getViewVector(1.0F); // Uses Minecraft's built-in direction

    // Extend the ray distance for better accuracy
    BlockHitResult hitResult = level.clip(new ClipContext(eyePos, eyePos.add(viewVector.scale(6)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, player));

    return (hitResult.getType() == HitResult.Type.BLOCK) ? hitResult.getDirection() : null;
  }



  @SubscribeEvent
  public static void onChiselUsage(BlockEvent.BreakEvent event) {
    Player player = event.getPlayer();
    ItemStack mainHandItem = player.getMainHandItem();

    if (mainHandItem.getItem() instanceof ChiselItem) {
      Map<Block, BlockState> CHISEL_BLOCK = Map.of(
          Blocks.DEEPSLATE, Blocks.COBBLED_DEEPSLATE.defaultBlockState(),
          Blocks.COBBLED_DEEPSLATE, Blocks.STONE.defaultBlockState(),
          Blocks.STONE, Blocks.COBBLESTONE.defaultBlockState(),
          Blocks.COBBLESTONE, Blocks.GRAVEL.defaultBlockState()
      );
      Map<Block, ItemStack> CHISEL_ITEM = Map.of(
          Blocks.DEEPSLATE, new ItemStack(Items.GRAVEL),
          Blocks.COBBLED_DEEPSLATE, new ItemStack(Items.GRAVEL),
          Blocks.STONE, new ItemStack(Items.GRAVEL),
          Blocks.COBBLESTONE, new ItemStack(Items.GRAVEL)
      );
      event.setCanceled(true);
      if (player instanceof ServerPlayer) {
        BlockPos initialBlockPos = event.getPos();
        if (CHISEL_BLOCK.containsKey(event.getState().getBlock())) {
          event.getLevel().setBlock(initialBlockPos, CHISEL_BLOCK.get(event.getState().getBlock()), 35);
          Block.popResourceFromFace((Level) event.getLevel(), initialBlockPos, Objects.requireNonNull(getTargetedFace(player, (Level) event.getLevel())), CHISEL_ITEM.get(event.getState().getBlock()));
          mainHandItem.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
          player.sendSystemMessage(Component.literal(Objects.requireNonNull(getTargetedFace(player, (Level) event.getLevel())).toString()));
          player.sendSystemMessage(Component.literal(CHISEL_ITEM.get(event.getState().getBlock()).toString()));
          player.sendSystemMessage(Component.literal(((Level) event.getLevel()).toString()));
          player.sendSystemMessage(Component.literal(initialBlockPos.toString()));
          player.sendSystemMessage(Component.literal(event.getState().toString()));
          player.sendSystemMessage(Component.literal(CHISEL_ITEM.toString()));
        }

      }
    }
  }
}
