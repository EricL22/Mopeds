package net.mcreator.moped.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.moped.init.MopedModItems;

public class CopperMopedEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack drop = ItemStack.EMPTY;
		drop = new ItemStack(MopedModItems.COPPER_MOPED_ITEM.get()).copy();
		drop.set(DataComponents.CUSTOM_NAME, Component.literal((((entity.getDisplayName().getString()).replace("]", "")).replace("[", ""))));
		{
			final String _tagName = "Fuel";
			final double _tagValue = (entity.getPersistentData().getDouble("Fuel"));
			CustomData.update(DataComponents.CUSTOM_DATA, drop, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
			entityToSpawn.setPickUpDelay(10);
			_level.addFreshEntity(entityToSpawn);
		}
	}
}
