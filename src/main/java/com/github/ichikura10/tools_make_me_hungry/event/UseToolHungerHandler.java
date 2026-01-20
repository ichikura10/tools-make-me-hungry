package com.github.ichikura10.tools_make_me_hungry.event;

import com.github.ichikura10.tools_make_me_hungry.ToolsMakeMeHungry;
import com.github.ichikura10.tools_make_me_hungry.util.HungerUtil;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ToolsMakeMeHungry.MOD_ID)
public class UseToolHungerHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();

        if (player.level().isClientSide()) {
            return;
        }

        if (player.isCreative()) {
            return;
        }

        if (!(player.getMainHandItem().getItem() instanceof  TieredItem)) {
            return;
        }

        HungerUtil.apply(player);
    }
}