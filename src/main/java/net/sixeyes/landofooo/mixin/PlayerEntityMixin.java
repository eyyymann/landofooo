package net.sixeyes.landofooo.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.sixeyes.landofooo.registry.ModItems;
import net.sixeyes.landofooo.registry.ModStatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;updateTurtleHelmet()V"))
    private void mixin(CallbackInfo ci) {
        updateIceCrown();
    }

    @Unique
    private void updateIceCrown() {
        PlayerEntity t = ((PlayerEntity)(Object)this);
        ItemStack itemStack = t.getEquippedStack(EquipmentSlot.HEAD);
        if (itemStack.isOf(ModItems.ICE_CROWN)) {
            t.addStatusEffect(new StatusEffectInstance(
                    ModStatusEffects.FROZEN_WHISPERS,
                    200, 0, false, false, true)
            );
        }

    }

}
