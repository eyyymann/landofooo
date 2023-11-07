package net.sixeyes.landofooo.entity.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.entity.TheLichEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TheLichEntityModel extends GeoModel<TheLichEntity> {
    @Override
    public Identifier getModelResource(TheLichEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "geo/the_lich.geo.json");
    }

    @Override
    public Identifier getTextureResource(TheLichEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "textures/entity/the_lich/the_lich.png");
    }

    @Override
    public Identifier getAnimationResource(TheLichEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "animations/penguin.animation.json");
    }

    @Override
    public void setCustomAnimations(TheLichEntity animatable, long instanceId, AnimationState<TheLichEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
