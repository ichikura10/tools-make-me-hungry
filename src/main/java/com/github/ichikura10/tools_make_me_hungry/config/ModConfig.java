package com.github.ichikura10.tools_make_me_hungry.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {

    public static final ForgeConfigSpec COMMON_SPEC;

    public static ForgeConfigSpec.IntValue HUNGER_COST;
    public static ForgeConfigSpec.BooleanValue KILL_AT_ZERO;
    public static ForgeConfigSpec.BooleanValue IGNORE_CREATIVE;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push("general");

        HUNGER_COST = builder
                .comment("How much hunger is consumed per tool use\nDefault: 1")
                .defineInRange("hungerCost", 1, 0, 20);

        KILL_AT_ZERO = builder
                .comment("Kill the player when hunger reaches 0\nDefault: true\nOnly true or false")
                .define("killAtZero", true);

        IGNORE_CREATIVE = builder
                .comment("If true, creative mode players are ignored\nDefault: true\nOnly true or false")
                .define("ignoreCreative", true);

        builder.pop();

        COMMON_SPEC = builder.build();
    }
}
