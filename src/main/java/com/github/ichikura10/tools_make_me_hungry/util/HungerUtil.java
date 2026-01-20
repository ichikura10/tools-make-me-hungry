package com.github.ichikura10.tools_make_me_hungry.util;

import com.github.ichikura10.tools_make_me_hungry.config.ModConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

public class HungerUtil {
    public static void apply(Player player) {
        FoodData food = player.getFoodData();
        int cost = ModConfig.HUNGER_COST.get();

        if (food.getFoodLevel() == 0) {
            if (ModConfig.KILL_AT_ZERO.get()) {
                player.setHealth(1);
                player.hurt(createSource(player), Integer.MAX_VALUE);
            }
        }
        else {
            food.eat(-cost, 0.0F);
        }
    }

    private static DamageSource createSource(Player player) {
        return new DamageSource(
                player.level()
                        .registryAccess()
                        .registryOrThrow(Registries.DAMAGE_TYPE)
                        .getHolderOrThrow(ModDamageTypes.TOOL_HUNGRY)
        );
    }
}