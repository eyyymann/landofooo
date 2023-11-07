package net.sixeyes.landofooo.entity.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.entity.TheLichEntity;
import net.sixeyes.landofooo.entity.model.TheLichEntityModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TheLichEntityRenderer extends GeoEntityRenderer<TheLichEntity> {
    public TheLichEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TheLichEntityModel());
    }

    @Override
    public Identifier getTextureLocation(TheLichEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "textures/entity/the_lich/the_lich.png");
    }

    @Override
    public void render(TheLichEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
