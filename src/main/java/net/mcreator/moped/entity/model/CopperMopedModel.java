package net.mcreator.moped.entity.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.moped.entity.CopperMopedEntity;

public class CopperMopedModel extends GeoModel<CopperMopedEntity> {
	@Override
	public ResourceLocation getAnimationResource(CopperMopedEntity entity) {
		return ResourceLocation.parse("moped:animations/copper_moped.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CopperMopedEntity entity) {
		return ResourceLocation.parse("moped:geo/copper_moped.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CopperMopedEntity entity) {
		return ResourceLocation.parse("moped:textures/entities/" + entity.getTexture() + ".png");
	}

}
