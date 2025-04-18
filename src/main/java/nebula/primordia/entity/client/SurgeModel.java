package nebula.primordia.entity.client;

import nebula.primordia.Primordia;
import nebula.primordia.entity.custom.SurgeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SurgeModel <T extends SurgeEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer SURGE = new EntityModelLayer(Identifier.of(Primordia.MOD_ID, "surge"), "main");
    private final ModelPart surge;
    private final ModelPart head;
    public SurgeModel(ModelPart root) {
        this.surge = root.getChild("Surge");
        this.head = this.surge.getChild("Head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Surge = modelPartData.addChild("Surge", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 20.0F, 0.0F));

        ModelPartData Head = Surge.addChild("Head", ModelPartBuilder.create().uv(0, 34).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, 0.0F));

        ModelPartData Eyebrows = Head.addChild("Eyebrows", ModelPartBuilder.create().uv(0, 80).cuboid(-5.0F, -4.0F, -2.5F, 10.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -1.5F, -1.75F));

        ModelPartData SurgeRods = Surge.addChild("SurgeRods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = SurgeRods.addChild("cube_r1", ModelPartBuilder.create().uv(16, 70).cuboid(-1.0F, -8.0F, 5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3927F, 1.0472F, 0.0F));

        ModelPartData cube_r2 = SurgeRods.addChild("cube_r2", ModelPartBuilder.create().uv(16, 70).cuboid(-1.0F, -8.0F, 5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.7489F, 1.0472F, 3.1416F));

        ModelPartData cube_r3 = SurgeRods.addChild("cube_r3", ModelPartBuilder.create().uv(16, 70).cuboid(-1.0F, -8.0F, 5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.7925F, 0.0F, 3.1416F));

        ModelPartData cube_r4 = SurgeRods.addChild("cube_r4", ModelPartBuilder.create().uv(16, 70).cuboid(-1.0F, -8.0F, 5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 2.7925F, -1.0472F, 3.1416F));

        ModelPartData cube_r5 = SurgeRods.addChild("cube_r5", ModelPartBuilder.create().uv(16, 70).cuboid(-1.0F, -8.0F, 5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, -1.0472F, 0.0F));

        ModelPartData cube_r6 = SurgeRods.addChild("cube_r6", ModelPartBuilder.create().uv(16, 70).cuboid(-1.0F, -8.0F, 5.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData StormClouds = Surge.addChild("StormClouds", ModelPartBuilder.create().uv(32, 34).cuboid(-15.0F, -3.0F, 0.0F, 6.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(32, 46).cuboid(-14.0F, -1.0F, -2.0F, 6.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(0, 50).cuboid(-16.0F, -2.0F, 1.0F, 6.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(60, 34).cuboid(-4.0F, 3.0F, -14.0F, 8.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 62).cuboid(-1.0F, 4.0F, -12.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(28, 58).cuboid(10.0F, 5.0F, -1.0F, 5.0F, 4.0F, 8.0F, new Dilation(0.0F))
                .uv(54, 58).cuboid(11.0F, 7.0F, -3.0F, 5.0F, 3.0F, 8.0F, new Dilation(0.0F))
                .uv(60, 52).cuboid(9.0F, 4.0F, 6.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(60, 43).cuboid(-2.0F, 0.0F, 11.0F, 7.0F, 5.0F, 4.0F, new Dilation(0.0F))
                .uv(54, 69).cuboid(-1.0F, 2.0F, 10.0F, 7.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, 0.0F));

        ModelPartData LightningAura = Surge.addChild("LightningAura", ModelPartBuilder.create().uv(0, 0).cuboid(-13.0F, -5.0F, -13.0F, 26.0F, 8.0F, 26.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -10.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(SurgeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(SurgeAnimations.ANIM_SURGE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, SurgeAnimations.ANIM_SURGE_IDLE, ageInTicks, 1f);
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        surge.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return surge;
    }
}
