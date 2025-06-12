package com.jonathan.laterthanwolves.item;

import com.jonathan.laterthanwolves.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
  public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
      150, 5F, 1.5F, 19, () -> Ingredient.of(Items.COPPER_INGOT));
}
