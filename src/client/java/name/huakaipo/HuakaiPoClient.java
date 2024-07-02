package name.huakaipo;

import name.huakaipo.entity.ModEntities;
import name.huakaipo.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class HuakaiPoClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.TIKI_MAN, TikiManRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.TIKI_MAN, tiki_man::getTexturedModelData);
		EntityRendererRegistry.register(ModEntities.GODSLAYER, GodslayerRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GODSLAYER, godslayer::getTexturedModelData);
	}
}