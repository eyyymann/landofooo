package net.sixeyes.landofooo.entity.model;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.entity.PenguinEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class PenguinEntityModel extends GeoModel<PenguinEntity> {
    @Override
    public Identifier getModelResource(PenguinEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "geo/penguin.geo.json");
    }

    @Override
    public Identifier getTextureResource(PenguinEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "textures/entity/penguin/penguin.png");
    }

    @Override
    public Identifier getAnimationResource(PenguinEntity animatable) {
        return new Identifier(LandOfOooMod.MOD_ID, "animations/penguin.animation.json");
    }

    @Override
    public void setCustomAnimations(PenguinEntity animatable, long instanceId, AnimationState<PenguinEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
