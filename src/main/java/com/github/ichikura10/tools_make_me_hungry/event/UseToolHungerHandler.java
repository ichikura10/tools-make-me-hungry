package com.github.ichikura10.tools_make_me_hungry.event;

import com.github.ichikura10.tools_make_me_hungry.ToolsMakeMeHungry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ToolsMakeMeHungry.MOD_ID)
public class UseToolHungerHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();

        if (!(player.level().isClientSide())) {
            if (player.getMainHandItem().getItem() instanceof TieredItem) {

                FoodData food = player.getFoodData();

                if (food.getFoodLevel() == 0) {
                    player.kill();
                }

                else {
                    food.eat(-1, 0.0F);
                }
            }
        }
    }
}