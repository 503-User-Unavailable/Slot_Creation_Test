package com.mozmail.njf671e1t.slotcreate.items;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.util.ISlotHelper;

public class slotter extends Item {

    public slotter(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        final ItemStack stack = player.getItemInHand(hand);
        ISlotHelper slotty = CuriosApi.getSlotHelper();
        int backNum = slotty.getSlotsForType(player, "back");
        if (2 > backNum) {
            slotty.setSlotsForType("back", player, backNum + 1);
            stack.setCount( stack.getCount() - 1 );
            if (world.isClientSide){
                player.playSound(SoundEvents.LIGHTNING_BOLT_THUNDER);
            }
            return InteractionResultHolder.consume(stack);
        }
        else {
            //failure sound here
            if (world.isClientSide){
                player.displayClientMessage(Component.literal("Max Slot Amount Reached"), canRepair);
                
            }
            return InteractionResultHolder.fail(stack);
        }
    }
}
