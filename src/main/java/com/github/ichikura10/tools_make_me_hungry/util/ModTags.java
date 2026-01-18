package com.github.ichikura10.tools_make_me_hungry.util;

import com.github.ichikura10.tools_make_me_hungry.ToolsMakeMeHungry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> HUNGER_ITEMS = tag("hunger_items");
        public static final TagKey<Item> HUNGER_TOOLS = tag("hunger_tools");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ToolsMakeMeHungry.MOD_ID, name));
        }
    }
}
