package net.sixeyes.landofooo.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.sixeyes.landofooo.registry.ModBlocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CraftingScreenHandler.class)
public class CraftingScreenHandlerMixin {

    @Final
    @Shadow
    private
    ScreenHandlerContext context;

    @Inject(method = "canUse", at = @At("HEAD"), cancellable = true)
    private void mixin(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(
                ScreenHandlerInvoker.canUse(context, player, Blocks.CRAFTING_TABLE) ||
                        ScreenHandlerInvoker.canUse(context, player, ModBlocks.ICE_CRAFTING_TABLE)
        );
    }
}
