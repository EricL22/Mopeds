
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.moped.potion.OutOfFuelMobEffect;
import net.mcreator.moped.potion.MopedMakesSoundMobEffect;
import net.mcreator.moped.potion.HasFuelMobEffect;
import net.mcreator.moped.MopedMod;

public class MopedModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, MopedMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> MOPED_MAKES_SOUND = REGISTRY.register("moped_makes_sound", () -> new MopedMakesSoundMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> OUT_OF_FUEL = REGISTRY.register("out_of_fuel", () -> new OutOfFuelMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> HAS_FUEL = REGISTRY.register("has_fuel", () -> new HasFuelMobEffect());
}
