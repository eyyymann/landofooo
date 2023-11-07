package net.sixeyes.landofooo.mixin;

import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BackgroundRenderer.DarknessFogModifier.class)
public interface DarknessFogModifierInvoker {
    @Invoker("<init>")
    static BackgroundRenderer.DarknessFogModifier newDarknessFogModifier() {
        throw new AssertionError();
    }
}
