package net.sixeyes.landofooo.registry;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.block.fluid.AcidFluid;
import net.sixeyes.landofooo.block.fluid.ButterscotchFluid;

import java.util.ArrayList;
import java.util.List;

public class ModFluids {

    // LIST OF FLUIDS
    public static List<Pair<String, FlowableFluid>> FLUIDS = new ArrayList<>();

    public static FlowableFluid STILL_BUTTERSCOTCH = Registry.register(Registries.FLUID,
            new Identifier(LandOfOooMod.MOD_ID, "still_butterscotch"), new ButterscotchFluid.Still());
    public static FlowableFluid FLOWING_BUTTERSCOTCH = Registry.register(Registries.FLUID,
            new Identifier(LandOfOooMod.MOD_ID, "flowing_butterscotch"), new ButterscotchFluid.Flowing());
    public static FlowableFluid STILL_ACID = Registry.register(Registries.FLUID,
            new Identifier(LandOfOooMod.MOD_ID, "still_acid"), new AcidFluid.Still());
    public static FlowableFluid FLOWING_ACID = Registry.register(Registries.FLUID,
            new Identifier(LandOfOooMod.MOD_ID, "flowing_acid"), new AcidFluid.Flowing());

    public static void registerFluids() {

        LandOfOooMod.LOGGER.info("Registering Mod Fluids " + LandOfOooMod.MOD_ID);
    }
}
