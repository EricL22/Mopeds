
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.moped.MopedMod;

public class MopedModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MopedMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MOPEDS_TAB = REGISTRY.register("mopeds_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.moped.mopeds_tab")).icon(() -> new ItemStack(MopedModItems.COPPER_MOPED_ITEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(MopedModItems.COPPER_MOPED_ITEM.get());
				tabData.accept(MopedModItems.MOPED_BOOSTER_ITEM.get());
				tabData.accept(MopedModBlocks.MOPED_SIGN_BLOCK.get().asItem());
				tabData.accept(MopedModBlocks.MOPED_SIGN_BLUE_BLOCK.get().asItem());
				tabData.accept(MopedModBlocks.PARKING_SIGN_BLUE_BLOCK.get().asItem());
				tabData.accept(MopedModBlocks.MOPED_SIGN_TRAPDOOR.get().asItem());
				tabData.accept(MopedModBlocks.MOPED_SIGN_BLUE_TRAPDOOR.get().asItem());
				tabData.accept(MopedModBlocks.PARKING_SIGN_TRAPDOOR.get().asItem());
				tabData.accept(MopedModBlocks.EMPTY_SIGN_BLUE_BLOCK.get().asItem());
				tabData.accept(MopedModBlocks.EMPTY_SIGN_BLUE_TRAPDOOR.get().asItem());
				tabData.accept(MopedModItems.TINY_COPPER_MOPED_ITEM.get());
				tabData.accept(MopedModItems.MOPED_KEY.get());
			}).build());
}
