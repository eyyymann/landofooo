package net.sixeyes.landofooo.mixin;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ScreenHandler.class)
public interface ScreenHandlerInvoker {
    @Invoker("canUse")
    static boolean canUse(ScreenHandlerContext context, PlayerEntity player, Block block) {
        throw new AssertionError();
    }
}
