package net.mcreator.moped.procedures;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.moped.init.MopedModMobEffects;
import net.mcreator.moped.entity.TinyCopperMopedEntity;
import net.mcreator.moped.entity.CopperMopedEntity;

import java.util.ArrayList;

public class CopperMopedOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack Fuel = ItemStack.EMPTY;
		double NrOfBoosters = 0;
		Entity Rider = null;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(MopedModMobEffects.HAS_FUEL)) {
			if (entity.isVehicle()) {
				if (!(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MopedModMobEffects.MOPED_MAKES_SOUND))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MopedModMobEffects.MOPED_MAKES_SOUND, 47, 0, true, true));
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("moped:moped.engine.idling")), SoundSource.NEUTRAL, (float) 0.2, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("moped:moped.engine.idling")), SoundSource.NEUTRAL, (float) 0.2, 1, false);
						}
					}
					if (entity.getDeltaMovement().x() != 0 || entity.getDeltaMovement().z() != 0) {
						if (Math.random() > 0.5) {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("moped:moped.engine.rev1")), SoundSource.NEUTRAL, (float) 0.4, (float) Math.random());
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("moped:moped.engine.rev1")), SoundSource.NEUTRAL, (float) 0.4, (float) Math.random(), false);
								}
							}
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("moped:moped.engine.rev2")), SoundSource.NEUTRAL, (float) 0.4, (float) Math.random());
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("moped:moped.engine.rev2")), SoundSource.NEUTRAL, (float) 0.4, (float) Math.random(), false);
								}
							}
						}
					}
				}
			}
		}
		NrOfBoosters = entity.getPersistentData().getDouble("NrOfBoosters");
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
		if (NrOfBoosters > 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, (int) (NrOfBoosters - 1), false, false));
		}
		if (entity instanceof CopperMopedEntity animatable)
			animatable.setTexture(("moped" + Math.round(NrOfBoosters)));
		if (entity instanceof TinyCopperMopedEntity animatable)
			animatable.setTexture(("moped" + Math.round(NrOfBoosters)));
		if ((entity.getDeltaMovement().x() != 0 || entity.getDeltaMovement().z() != 0) && entity.isVehicle()) {
			if (entity instanceof CopperMopedEntity animatable)
				animatable.setTexture(("moped_anim" + Math.round(NrOfBoosters)));
			if (entity instanceof TinyCopperMopedEntity animatable)
				animatable.setTexture(("moped" + Math.round(NrOfBoosters)));
			if (entity instanceof LivingEntity _livEnt19 && _livEnt19.hasEffect(MobEffects.MOVEMENT_SPEED)) {
				entity.getPersistentData().putDouble("Fuel",
						(entity.getPersistentData().getDouble("Fuel") - Math.pow(2, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) + 1)));
			} else {
				entity.getPersistentData().putDouble("Fuel", (entity.getPersistentData().getDouble("Fuel") - 1));
			}
		}
		Fuel = (new Object() {
			public ItemStack getItemStack(int sltid, Entity entity) {
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
					return _modHandler.getStackInSlot(sltid).copy();
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack(0, entity)).copy();
		if (entity.getPersistentData().getDouble("Fuel") <= 1) {
			if (Fuel.getBurnTime(null) > 0) {
				entity.getPersistentData().putDouble("Fuel", (Fuel.getBurnTime(null)));
				if (Fuel.getItem() == Items.LAVA_BUCKET) {
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
						_setstack.setCount(1);
						_modHandler.setStackInSlot(0, _setstack);
					}
				} else {
					Fuel.shrink(1);
					if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
						ItemStack _setstack = Fuel.copy();
						_setstack.setCount(Fuel.getCount());
						_modHandler.setStackInSlot(0, _setstack);
					}
				}
			}
		}
		if (entity.getPersistentData().getDouble("Fuel") <= 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MopedModMobEffects.OUT_OF_FUEL, 10, 0, false, false));
		} else {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MopedModMobEffects.HAS_FUEL);
			if (entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MobEffects.MOVEMENT_SPEED)) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MopedModMobEffects.HAS_FUEL, (int) ((entity.getPersistentData().getDouble("Fuel") + Fuel.getCount() * Fuel.getBurnTime(null))
							/ Math.pow(2, (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) ? _livEnt.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0) + 1)), 0, false, false));
			} else {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MopedModMobEffects.HAS_FUEL, (int) (entity.getPersistentData().getDouble("Fuel") + Fuel.getCount() * Fuel.getBurnTime(null)), 0, false, false));
			}
		}
		if (NrOfBoosters >= 3) {
			for (Entity entityiterator : new ArrayList<>(entity.getPassengers())) {
				if (entityiterator instanceof ServerPlayer _player) {
					AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("moped:fully_upgraded_moped"));
					if (_adv != null) {
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							for (String criteria : _ap.getRemainingCriteria())
								_player.getAdvancements().award(_adv, criteria);
						}
					}
				}
			}
		}
		if (new Object() {
			public double getSubmergedHeight(Entity _entity) {
				for (FluidType fluidType : NeoForgeRegistries.FLUID_TYPES) {
					if (_entity.level().getFluidState(_entity.blockPosition()).getFluidType() == fluidType)
						return _entity.getFluidTypeHeight(fluidType);
				}
				return 0;
			}
		}.getSubmergedHeight(entity) >= entity.getBbHeight()) {
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DROWN)), 10);
		}
	}
}
