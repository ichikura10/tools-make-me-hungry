package com.github.ichikura10.tools_make_me_hungry.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

public class HungerUtil {
    public static void apply(Player player) {
        FoodData food = player.getFoodData();

        if (food.getFoodLevel() == 0) {
            player.die(createSource(player));
        }
        else {
            food.eat(-1, 0.0F);
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