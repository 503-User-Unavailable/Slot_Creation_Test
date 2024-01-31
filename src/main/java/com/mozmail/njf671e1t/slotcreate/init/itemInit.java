package com.mozmail.njf671e1t.slotcreate.init;

import com.mozmail.njf671e1t.slotcreate.slotCreateMain;
import com.mozmail.njf671e1t.slotcreate.items.slotter;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class itemInit {
    //making the creative mode tab for it
    public static class ModCreativeTab extends CreativeModeTab {
        private ModCreativeTab(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(SLOT_CREATE.get());
        }

        public static final ModCreativeTab slotter = new ModCreativeTab(CreativeModeTab.TABS.length, "slotcreate");
    }

    //deffered register
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, slotCreateMain.MODID);

    //item to make curio back slots (max of 2)
    public static final RegistryObject<Item> SLOT_CREATE = ITEMS.register("slotter",
        () -> new slotter(new Item.Properties().tab(ModCreativeTab.slotter).stacksTo(1)));
}
