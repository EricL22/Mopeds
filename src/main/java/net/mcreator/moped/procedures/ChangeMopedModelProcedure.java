package net.mcreator.moped.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.moped.init.MopedModEntities;
import net.mcreator.moped.entity.CopperMopedEntity;

import java.util.Comparator;

public class ChangeMopedModelProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double InventorySlot = 0;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = MopedModEntities.COPPER_MOPED.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(entity.getYRot());
				entityToSpawn.setYBodyRot(entity.getYRot());
				entityToSpawn.setYHeadRot(entity.getYRot());
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
		InventorySlot = 0;
		while (InventorySlot <= 4) {
			if (((Entity) world.getEntitiesOfClass(CopperMopedEntity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
				ItemStack _setstack = (new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) InventorySlot, entity)).copy();
				_setstack.setCount((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) InventorySlot, entity)).getCount());
				_modHandler.setStackInSlot((int) InventorySlot, _setstack);
			}
			InventorySlot = InventorySlot + 1;
		}
		entity.getPersistentData().putDouble("Fuel", (entity.getPersistentData().getDouble("Fuel")));
	}
}
