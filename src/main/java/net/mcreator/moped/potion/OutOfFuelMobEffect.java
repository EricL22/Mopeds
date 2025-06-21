
package net.mcreator.moped.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.moped.procedures.OutOfFuelOnEffectActiveTickProcedure;

public class OutOfFuelMobEffect extends MobEffect {
	public OutOfFuelMobEffect() {
		super(MobEffectCategory.HARMFUL, -1);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		OutOfFuelOnEffectActiveTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
