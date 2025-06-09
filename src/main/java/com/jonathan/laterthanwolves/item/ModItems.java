package com.jonathan.laterthanwolves.item;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.item.custom.ChiselItem;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
  public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(
      LaterThanWolves.MOD_ID
  );

  public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
      () -> new Item(new Item.Properties()));

  public static final DeferredItem<Item> DIAMOND_CHISEL = ITEMS.register("diamond_chisel",
      () -> new ChiselItem(Tiers.DIAMOND, new Item.Properties()));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }


}
