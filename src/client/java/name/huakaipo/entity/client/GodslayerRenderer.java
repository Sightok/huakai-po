package name.huakaipo.entity.client;

import name.huakaipo.HuakaiPo;
import name.huakaipo.entity.custom.GodslayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GodslayerRenderer extends MobEntityRenderer<GodslayerEntity, godslayer<GodslayerEntity>> {
    private static final Identifier TEXTURE = Identifier.of(HuakaiPo.MOD_ID, "textures/entity/godslayer.png");

    public GodslayerRenderer(EntityRendererFactory.Context context) {
        super(context, new godslayer<>(context.getPart(ModModelLayers.GODSLAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(GodslayerEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GodslayerEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
