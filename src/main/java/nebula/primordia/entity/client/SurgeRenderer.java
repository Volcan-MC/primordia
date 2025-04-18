package nebula.primordia.entity.client;

import nebula.primordia.Primordia;
import nebula.primordia.entity.custom.SurgeEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SurgeRenderer extends MobEntityRenderer<SurgeEntity, SurgeModel<SurgeEntity>> {
    public SurgeRenderer(EntityRendererFactory.Context context) {
        super(context, new SurgeModel<>(context.getPart(SurgeModel.SURGE)), 0.75f);
    }

    @Override
    public Identifier getTexture(SurgeEntity entity) {
        return Identifier.of(Primordia.MOD_ID, "textures/entity/surge/surge.png");
    }
    @Override
    public void render(SurgeEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
