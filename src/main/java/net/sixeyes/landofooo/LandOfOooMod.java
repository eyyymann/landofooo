package net.sixeyes.landofooo;

import net.fabricmc.api.ModInitializer;

import net.sixeyes.landofooo.registry.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LandOfOooMod implements ModInitializer {

	public static final String MOD_ID = "landofooo";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModEntities.registerModEntities();
		ModFluids.registerFluids();
		ModBlocks.registerBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModStatusEffects.registerModStatusEffects();
		LOGGER.info("Hello Fabric world!");
	}
}