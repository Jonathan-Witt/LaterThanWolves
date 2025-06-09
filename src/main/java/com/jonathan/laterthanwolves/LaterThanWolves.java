package com.jonathan.laterthanwolves;

import com.jonathan.laterthanwolves.block.ModBlocks;
import com.jonathan.laterthanwolves.item.ModCreativeModeTabs;
import com.jonathan.laterthanwolves.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

@Mod(LaterThanWolves.MOD_ID)
public class LaterThanWolves {

  public static final String MOD_ID = "laterthanwolves";
  private static final Logger LOGGER = LogUtils.getLogger();

  public LaterThanWolves(IEventBus modEventBus, ModContainer modContainer) {
    modEventBus.addListener(this::commonSetup);

    NeoForge.EVENT_BUS.register(this);

    ModCreativeModeTabs.register(modEventBus);

    ModItems.register(modEventBus);
    ModBlocks.register(modEventBus);

    modEventBus.addListener(this::addCreative);

    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {

  }

  private void addCreative(BuildCreativeModeTabContentsEvent event) {
    if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
      event.accept(ModItems.STEEL_INGOT);
    }
    if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
      event.accept(ModBlocks.STEEL_BLOCK);
    }
  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {

  }

  @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

    }
  }
}
