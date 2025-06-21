
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.moped.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.moped.client.renderer.TinyCopperMopedRenderer;
import net.mcreator.moped.client.renderer.CopperMopedRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MopedModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(MopedModEntities.COPPER_MOPED.get(), CopperMopedRenderer::new);
		event.registerEntityRenderer(MopedModEntities.TINY_COPPER_MOPED.get(), TinyCopperMopedRenderer::new);
	}
}
