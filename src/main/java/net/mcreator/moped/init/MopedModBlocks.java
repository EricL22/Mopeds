
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.moped.block.ParkingSignTrapDoorBlock;
import net.mcreator.moped.block.ParkingSignBlueBlock;
import net.mcreator.moped.block.MopedSignTrapDoorBlock;
import net.mcreator.moped.block.MopedSignBlueTrapDoorBlock;
import net.mcreator.moped.block.MopedSignBlueBlockBlock;
import net.mcreator.moped.block.MopedSignBlockBlock;
import net.mcreator.moped.block.EmptySignBlueTrapdoorBlock;
import net.mcreator.moped.block.EmptySignBlueBlock;
import net.mcreator.moped.MopedMod;

public class MopedModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(MopedMod.MODID);
	public static final DeferredBlock<Block> MOPED_SIGN_BLOCK = REGISTRY.register("moped_sign_block", MopedSignBlockBlock::new);
	public static final DeferredBlock<Block> MOPED_SIGN_BLUE_BLOCK = REGISTRY.register("moped_sign_blue_block", MopedSignBlueBlockBlock::new);
	public static final DeferredBlock<Block> PARKING_SIGN_BLUE_BLOCK = REGISTRY.register("parking_sign_blue_block", ParkingSignBlueBlock::new);
	public static final DeferredBlock<Block> MOPED_SIGN_TRAPDOOR = REGISTRY.register("moped_sign_trapdoor", MopedSignTrapDoorBlock::new);
	public static final DeferredBlock<Block> MOPED_SIGN_BLUE_TRAPDOOR = REGISTRY.register("moped_sign_blue_trapdoor", MopedSignBlueTrapDoorBlock::new);
	public static final DeferredBlock<Block> PARKING_SIGN_TRAPDOOR = REGISTRY.register("parking_sign_trapdoor", ParkingSignTrapDoorBlock::new);
	public static final DeferredBlock<Block> EMPTY_SIGN_BLUE_BLOCK = REGISTRY.register("empty_sign_blue_block", EmptySignBlueBlock::new);
	public static final DeferredBlock<Block> EMPTY_SIGN_BLUE_TRAPDOOR = REGISTRY.register("empty_sign_blue_trapdoor", EmptySignBlueTrapdoorBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
