package com.jonathan.laterthanwolves.item;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
  public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LaterThanWolves.MOD_ID);

  public static final Supplier<CreativeModeTab> LATER_THAN_WOLVES = CREATIVE_MODE_TAB.register("later_than_wolves",
      () -> CreativeModeTab.builder()
          .icon(() -> new ItemStack(ModItems.STEEL_INGOT.get()))
          .title(Component.translatable("creativetab.laterthanwolves.laterthanwolves"))
          .displayItems((itemDisplayParameters, output) -> {
            output.accept(ModItems.STEEL_INGOT);
            output.accept(ModBlocks.STEEL_BLOCK);
            output.accept(ModItems.DIAMOND_CHISEL);

            output.accept(ModItems.COPPER_AXE);
            output.accept(ModItems.COPPER_HOE);
            output.accept(ModItems.COPPER_PICKAXE);
            output.accept(ModItems.COPPER_SHOVEL);
            output.accept(ModItems.COPPER_SWORD);
          })
          .build());

  public static void register (IEventBus eventBus) {
    CREATIVE_MODE_TAB.register(eventBus);
  }
}
