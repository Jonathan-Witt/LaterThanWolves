package com.jonathan.laterthanwolves.event;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.item.custom.ChiselItem;
import net.minecraft.client.telemetry.TelemetryProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber(modid = LaterThanWolves.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {
  @SubscribeEvent
  public static void onChiselUsage(BlockEvent.BreakEvent event) {
    Player player = event.getPlayer();
    ItemStack mainHandItem = player.getMainHandItem();
    event.setCanceled(true);
    if (mainHandItem.getItem() instanceof ChiselItem && player instanceof ServerPlayer) {
      BlockPos initialBlockPos = event.getPos();
      if (ChiselItem.CHISEL_BLOCK.containsKey(event.getState())) {
        event.getLevel().setBlock(initialBlockPos, ChiselItem.CHISEL_BLOCK.get(event.getState()), 35);
        Block.popResource((Level) event.getLevel(), initialBlockPos, ChiselItem.CHISEL_ITEM.get(event.getState()));
        mainHandItem.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
        event.getPlayer().getNearestViewDirection()
      }
    }
  }
}
