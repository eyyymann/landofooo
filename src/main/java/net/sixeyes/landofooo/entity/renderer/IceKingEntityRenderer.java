package net.sixeyes.landofooo.entity.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.entity.IceKingEntity;
import net.sixeyes.landofooo.entity.model.IceKingEntityModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IceKingEntityRenderer extends GeoEntityRenderer<IceKingEntity> {
    public IceKingEntityRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new IceKingEntityModel());
    }

    @Override
    public Identifier getTextureLocation(IceKingEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "textures/entity/ice_king/ice_king.png");
    }

    @Override
    public void render(IceKingEntity entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
