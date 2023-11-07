package net.sixeyes.landofooo.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.status_effect.FrozenWhispersStatusEffect;
import net.sixeyes.landofooo.status_effect.LichedStatusEffect;

import java.util.ArrayList;
import java.util.List;

public class ModStatusEffects {

    public static List<Pair<String, StatusEffect>> STATUS_EFFECTS = new ArrayList<>();

    public static final StatusEffect LICHED = registerStatusEffect("liched", new LichedStatusEffect());
    public static final StatusEffect FROZEN_WHISPERS = registerStatusEffect("frozen_whispers", new FrozenWhispersStatusEffect());

    private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect) {
        STATUS_EFFECTS.add(new Pair<>(name, statusEffect));
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(LandOfOooMod.MOD_ID, name), statusEffect);
    }

    public static void registerModStatusEffects() {

        LandOfOooMod.LOGGER.info("Registering Mod Mob Effects for " + LandOfOooMod.MOD_ID);
    }
}
