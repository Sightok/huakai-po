package name.huakaipo.entity.client;

import name.huakaipo.HuakaiPo;
import name.huakaipo.entity.custom.TikiManEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class TikiManRenderer extends MobEntityRenderer<TikiManEntity, tiki_man<TikiManEntity>> {
    private static final Identifier TEXTURE = Identifier.of(HuakaiPo.MOD_ID, "textures/entity/tiki_man.png");

    public TikiManRenderer(EntityRendererFactory.Context context) {
        super(context, new tiki_man<>(context.getPart(ModModelLayers.TIKI_MAN)), 0.5f);
    }

    @Override
    public Identifier getTexture(TikiManEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(TikiManEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
