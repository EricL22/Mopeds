package net.mcreator.moped.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.moped.init.MopedModItems;

import java.util.List;
import java.util.Comparator;

public class UpdateNrOfBoostersNBTProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double NrOfBoosters = 0;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("moped:mopeds")))) {
					try {
						NrOfBoosters = 0;
						if ((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(1, entityiterator)).getItem() == MopedModItems.MOPED_BOOSTER_ITEM.get()) {
							NrOfBoosters = NrOfBoosters + 1;
						}
						if ((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(2, entityiterator)).getItem() == MopedModItems.MOPED_BOOSTER_ITEM.get()) {
							NrOfBoosters = NrOfBoosters + 1;
						}
						if ((new Object() {
							public ItemStack getItemStack(int sltid, Entity entity) {
								if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
									return _modHandler.getStackInSlot(sltid).copy();
								}
								return ItemStack.EMPTY;
							}
						}.getItemStack(3, entityiterator)).getItem() == MopedModItems.MOPED_BOOSTER_ITEM.get()) {
							NrOfBoosters = NrOfBoosters + 1;
						}
						entityiterator.getPersistentData().putDouble("NrOfBoosters", NrOfBoosters);
					} catch (RuntimeException exc) {
						System.out.println("Caught an exception: " + exc + " This is likely caused by an old version of a moped in the world.");
					}
				}
			}
		}
	}
}
