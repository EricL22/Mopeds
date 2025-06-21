
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.moped.entity.TinyCopperMopedEntity;
import net.mcreator.moped.entity.CopperMopedEntity;
import net.mcreator.moped.MopedMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class MopedModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, MopedMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<CopperMopedEntity>> COPPER_MOPED = register("copper_moped",
			EntityType.Builder.<CopperMopedEntity>of(CopperMopedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 0.875f));
	public static final DeferredHolder<EntityType<?>, EntityType<TinyCopperMopedEntity>> TINY_COPPER_MOPED = register("tiny_copper_moped",
			EntityType.Builder.<TinyCopperMopedEntity>of(TinyCopperMopedEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.375f, 0.312f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerEntity(Capabilities.ItemHandler.ENTITY, COPPER_MOPED.get(), (living, context) -> living.getInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, TINY_COPPER_MOPED.get(), (living, context) -> living.getInventory());
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		CopperMopedEntity.init(event);
		TinyCopperMopedEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(COPPER_MOPED.get(), CopperMopedEntity.createAttributes().build());
		event.put(TINY_COPPER_MOPED.get(), TinyCopperMopedEntity.createAttributes().build());
	}
}
