package net.sixeyes.landofooo.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BackgroundRenderer.BlindnessFogModifier.class)
public interface BlindnessFogModifierInvoker {
    @Invoker("<init>")
    static BackgroundRenderer.BlindnessFogModifier newBlindnessFogModifier() {
        throw new AssertionError();
    }
}
