package net.sixeyes.landofooo.registry;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.entity.IceKingEntity;
import net.sixeyes.landofooo.entity.PenguinEntity;
import net.sixeyes.landofooo.entity.TheLichEntity;

import java.util.ArrayList;
import java.util.List;

public class ModEntities {

    public static List<Pair<String, EntityType<?>>> ENTITIES = new ArrayList<>();

    public static final EntityType<PenguinEntity> PENGUIN = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(LandOfOooMod.MOD_ID, "penguin"),
            FabricEntityTypeBuilder.create(
                    SpawnGroup.CREATURE, PenguinEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
                    .build()
    );

    public static final EntityType<TheLichEntity> THE_LICH = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(LandOfOooMod.MOD_ID, "the_lich"),
            FabricEntityTypeBuilder.create(
                            SpawnGroup.CREATURE, TheLichEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
                    .build()
    );

    public static final EntityType<IceKingEntity> ICE_KING = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(LandOfOooMod.MOD_ID, "ice_king"),
            FabricEntityTypeBuilder.create(
                            SpawnGroup.CREATURE, IceKingEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
                    .build()
    );

    public static void registerModEntities() {

        FabricDefaultAttributeRegistry.register(PENGUIN, PenguinEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(THE_LICH, PenguinEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ICE_KING, PenguinEntity.createMobAttributes());
        ENTITIES.add(new Pair<>("penguin", PENGUIN));
        ENTITIES.add(new Pair<>("the_lich", THE_LICH));
        ENTITIES.add(new Pair<>("ice_king", ICE_KING));

        LandOfOooMod.LOGGER.info("Registering Mod Entities for " + LandOfOooMod.MOD_ID);
    }
}
