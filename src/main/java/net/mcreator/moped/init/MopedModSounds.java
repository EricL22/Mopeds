
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.moped.MopedMod;

public class MopedModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, MopedMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_ENGINE_START = REGISTRY.register("moped.engine.start", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.engine.start")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_ENGINE_IDLING = REGISTRY.register("moped.engine.idling", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.engine.idling")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_ENGINE_REVVING = REGISTRY.register("moped.engine.revving", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.engine.revving")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_ENGINE_STOPS = REGISTRY.register("moped.engine.stops", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.engine.stops")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_ENGINE_REV1 = REGISTRY.register("moped.engine.rev1", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.engine.rev1")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_HURT = REGISTRY.register("moped.hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_BREAKS = REGISTRY.register("moped.breaks", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.breaks")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_FUEL_BUBBLES = REGISTRY.register("moped.fuel.bubbles", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.fuel.bubbles")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_FUEL_BURNS = REGISTRY.register("moped.fuel.burns", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.fuel.burns")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_SOUND_SILENCE = REGISTRY.register("moped.sound.silence", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.sound.silence")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_ENGINE_REV2 = REGISTRY.register("moped.engine.rev2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.engine.rev2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_HORN_HONKS = REGISTRY.register("moped.horn.honks", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.horn.honks")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_BREAKS2 = REGISTRY.register("moped.breaks2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.breaks2")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MOPED_HURT2 = REGISTRY.register("moped.hurt2", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("moped", "moped.hurt2")));
}
