package com.jonathan.laterthanwolves.item;

import com.jonathan.laterthanwolves.LaterThanWolves;
import com.jonathan.laterthanwolves.item.custom.ChiselItem;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
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

  public static final DeferredItem<Item> COPPER_SWORD = ITEMS.register("copper_sword",
      () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
          .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3, -2.4F))));

  public static final DeferredItem<Item> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
      () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
          .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 0F, -3F))));

  public static final DeferredItem<Item> COPPER_SHOVEL = ITEMS.register("copper_shovel",
      () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
          .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, -1F, -2.8F))));

  public static final DeferredItem<Item> COPPER_AXE = ITEMS.register("copper_axe",
      () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
          .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 6.5F, -3.2F))));

  public static final DeferredItem<Item> COPPER_HOE = ITEMS.register("copper_hoe",
      () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
          .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, -2F, -3.0F))));

  public static void register(IEventBus eventBus) {
    ITEMS.register(eventBus);
  }


}
