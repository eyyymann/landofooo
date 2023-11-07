package net.sixeyes.landofooo.mixin;

import com.google.common.collect.Lists;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.MathHelper;
import net.sixeyes.landofooo.registry.ModStatusEffects;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(BackgroundRenderer.class)
public class BackgroundRendererMixin {

    @Shadow
    @Final
    @Mutable
    private static final List<BackgroundRenderer.StatusEffectFogModifier> FOG_MODIFIERS = Lists.newArrayList(
        new BackgroundRenderer.StatusEffectFogModifier[]{DarknessFogModifierInvoker.newDarknessFogModifier(), BlindnessFogModifierInvoker.newBlindnessFogModifier(), new LichedFogModifier()}
    );

    @Mixin(BackgroundRenderer.StatusEffectFogModifier.class)
    public static class LichedFogModifier implements BackgroundRenderer.StatusEffectFogModifier {
        LichedFogModifier() {
        }

        public StatusEffect getStatusEffect() {
            return ModStatusEffects.LICHED;
        }

        public void applyStartEndModifier(BackgroundRenderer.FogData fogData, LivingEntity entity, StatusEffectInstance effect, float viewDistance, float tickDelta) {
            if (!effect.getFactorCalculationData().isEmpty()) {
                float f = MathHelper.lerp(effect.getFactorCalculationData().get().lerp(entity, tickDelta), viewDistance, 15.0F);
                fogData.fogStart = fogData.fogType == BackgroundRenderer.FogType.FOG_SKY ? 0.0F : f * 0.75F;
                fogData.fogEnd = f;
            }
        }

        public float applyColorModifier(LivingEntity entity, StatusEffectInstance effect, float f, float tickDelta) {
            return effect.getFactorCalculationData().isEmpty() ? 0.0F : 1.0F - effect.getFactorCalculationData().get().lerp(entity, tickDelta);
        }
    }
}
