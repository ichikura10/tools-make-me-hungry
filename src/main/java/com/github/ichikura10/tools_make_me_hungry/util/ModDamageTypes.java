package com.github.ichikura10.tools_make_me_hungry.util;

import com.github.ichikura10.tools_make_me_hungry.ToolsMakeMeHungry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

public class ModDamageTypes {

    public static final ResourceKey<DamageType> TOOL_HUNGRY =
            ResourceKey.create(
                    Registries.DAMAGE_TYPE,
                    new ResourceLocation(ToolsMakeMeHungry.MOD_ID, "tool_hungry")
            );
}
