
package net.mcreator.moped.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.moped.entity.model.CopperMopedModel;
import net.mcreator.moped.entity.layer.CopperMopedLayer;
import net.mcreator.moped.entity.CopperMopedEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class CopperMopedRenderer extends GeoEntityRenderer<CopperMopedEntity> {
	public CopperMopedRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new CopperMopedModel());
		this.shadowRadius = 0.6f;
		this.addRenderLayer(new CopperMopedLayer(this));
	}

	@Override
	public RenderType getRenderType(CopperMopedEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, CopperMopedEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int color) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, color);
	}
}
