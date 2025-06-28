
package net.mcreator.moped.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.moped.entity.model.TinyCopperMopedModel;
import net.mcreator.moped.entity.layer.TinyCopperMopedLayer;
import net.mcreator.moped.entity.TinyCopperMopedEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import software.bernie.geckolib.cache.object.GeoBone;
import java.util.Optional;

public class TinyCopperMopedRenderer extends GeoEntityRenderer<TinyCopperMopedEntity> {
	public TinyCopperMopedRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new TinyCopperMopedModel());
		this.shadowRadius = 0.2f;
		this.addRenderLayer(new TinyCopperMopedLayer(this));
	}

	@Override
	public RenderType getRenderType(TinyCopperMopedEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, TinyCopperMopedEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
		animateSteering(entity.getSteeringAngle());
	}

	private void animateSteering(float steeringAngle) {
		Optional<GeoBone> orudder = this.getGeoModel().getBone("Rudder");
		float radians = (float) Math.toRadians(steeringAngle);
		orudder.ifPresent(steeringWheel -> {
			steeringWheel.setRotY(radians);
		});
	}
}
