package com.github.ichikura10.tools_make_me_hungry.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;

public class HungerUtil {
    public static void apply(Player player) {
        FoodData food = player.getFoodData();

        if (food.getFoodLevel() == 0) {
            player.kill();
        } else {
            food.eat(-1, 0.0F);
        }
    }
}