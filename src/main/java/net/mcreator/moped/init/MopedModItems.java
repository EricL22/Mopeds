
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.moped.item.TinyCopperMopedItemItem;
import net.mcreator.moped.item.MopedKeyItem;
import net.mcreator.moped.item.MopedBoosterItemItem;
import net.mcreator.moped.item.CopperMopedItemItem;
import net.mcreator.moped.MopedMod;

public class MopedModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(MopedMod.MODID);
	public static final DeferredItem<Item> COPPER_MOPED_ITEM = REGISTRY.register("copper_moped_item", CopperMopedItemItem::new);
	public static final DeferredItem<Item> MOPED_BOOSTER_ITEM = REGISTRY.register("moped_booster_item", MopedBoosterItemItem::new);
	public static final DeferredItem<Item> MOPED_SIGN_BLOCK = block(MopedModBlocks.MOPED_SIGN_BLOCK);
	public static final DeferredItem<Item> MOPED_SIGN_BLUE_BLOCK = block(MopedModBlocks.MOPED_SIGN_BLUE_BLOCK);
	public static final DeferredItem<Item> PARKING_SIGN_BLUE_BLOCK = block(MopedModBlocks.PARKING_SIGN_BLUE_BLOCK);
	public static final DeferredItem<Item> MOPED_SIGN_TRAPDOOR = block(MopedModBlocks.MOPED_SIGN_TRAPDOOR);
	public static final DeferredItem<Item> MOPED_SIGN_BLUE_TRAPDOOR = block(MopedModBlocks.MOPED_SIGN_BLUE_TRAPDOOR);
	public static final DeferredItem<Item> PARKING_SIGN_TRAPDOOR = block(MopedModBlocks.PARKING_SIGN_TRAPDOOR);
	public static final DeferredItem<Item> EMPTY_SIGN_BLUE_BLOCK = block(MopedModBlocks.EMPTY_SIGN_BLUE_BLOCK);
	public static final DeferredItem<Item> EMPTY_SIGN_BLUE_TRAPDOOR = block(MopedModBlocks.EMPTY_SIGN_BLUE_TRAPDOOR);
	public static final DeferredItem<Item> TINY_COPPER_MOPED_ITEM = REGISTRY.register("tiny_copper_moped_item", TinyCopperMopedItemItem::new);
	public static final DeferredItem<Item> MOPED_KEY = REGISTRY.register("moped_key", MopedKeyItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
