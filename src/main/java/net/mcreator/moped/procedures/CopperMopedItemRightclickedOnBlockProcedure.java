package net.mcreator.moped.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.moped.init.MopedModEntities;

public class CopperMopedItemRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity, ItemStack itemstack) {
		if (direction == null || entity == null)
			return;
		double position = 0;
		Entity entityToSpawn = null;
		/*I need the next procedure block to introduce the world dependency*/
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ASH, (x + direction.getStepX()), y, z, 0, 3, 3, 3, 1);
		if (world instanceof ServerLevel _level) {
			entityToSpawn = MopedModEntities.COPPER_MOPED.get().spawn(_level, BlockPos.containing(x + direction.getStepX(), y + direction.getStepY(), z + direction.getStepZ()), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			itemstack.shrink(1);
		}
		if (!(entityToSpawn == null)) {
			if ((itemstack.getDisplayName().getString()).equals("[Copper Moped]")) {
				position = Mth.nextInt(RandomSource.create(), 0, 97);
				entityToSpawn.setCustomName(Component.literal(("CIMQUTRXVIOCLTRFJSLPTGNYQTXOPSVWGHWMOHEMITVALGHVQBMKUQMCGDPUQMVOYEJXZMJVOJXSDHYOTEWXNJJPEIUUTYHYVPMH".substring((int) position, (int) (position + 3)) + "-"
						+ Mth.nextInt(RandomSource.create(), 0, 9) + Mth.nextInt(RandomSource.create(), 0, 9) + Mth.nextInt(RandomSource.create(), 0, 9))));
			} else {
				entityToSpawn.setCustomName(Component.literal((((itemstack.getDisplayName().getString()).replace("]", "")).replace("[", ""))));
			}
			entityToSpawn.getPersistentData().putDouble("Fuel", (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Fuel")));
		}
	}
}
