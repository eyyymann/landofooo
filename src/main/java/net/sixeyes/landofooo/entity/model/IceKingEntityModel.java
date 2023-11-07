package net.sixeyes.landofooo.entity.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.entity.IceKingEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class IceKingEntityModel extends GeoModel<IceKingEntity> {
    @Override
    public Identifier getModelResource(IceKingEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "geo/ice_king.geo.json");
    }

    @Override
    public Identifier getTextureResource(IceKingEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "textures/entity/ice_king/ice_king.png");
    }

    @Override
    public Identifier getAnimationResource(IceKingEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "animations/penguin.animation.json");
    }

    @Override
    public void setCustomAnimations(IceKingEntity animatable, long instanceId, AnimationState<IceKingEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
