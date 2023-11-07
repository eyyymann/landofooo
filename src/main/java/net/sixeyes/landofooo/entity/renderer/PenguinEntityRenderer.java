package net.sixeyes.landofooo.entity.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.entity.PenguinEntity;
import net.sixeyes.landofooo.entity.model.PenguinEntityModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PenguinEntityRenderer extends GeoEntityRenderer<PenguinEntity> {
    public PenguinEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PenguinEntityModel());
    }

    @Override
    public Identifier getTextureLocation(PenguinEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "textures/entity/penguin/penguin.png");
    }

    @Override
    public void render(PenguinEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
