package com.github.ichikura10.tools_make_me_hungry.event;

import com.github.ichikura10.tools_make_me_hungry.ToolsMakeMeHungry;
import com.github.ichikura10.tools_make_me_hungry.util.HungerUtil;
import com.github.ichikura10.tools_make_me_hungry.util.ModTags;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ToolsMakeMeHungry.MOD_ID)
public class UseToolHungerHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();

        if (!(player.level().isClientSide())) {
            if (player.getMainHandItem().is(ModTags.Items.HUNGER_TOOLS)) {
                HungerUtil.apply(player);
            }
        }
    }

    @SubscribeEvent
        public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
            Player player = event.getEntity();

            if (!(player.level().isClientSide())) {
                if (event.getItemStack().is(ModTags.Items.HUNGER_ITEMS)){
                    HungerUtil.apply(player);
                }
            }
        }
}