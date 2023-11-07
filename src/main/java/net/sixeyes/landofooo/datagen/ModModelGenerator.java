package net.sixeyes.landofooo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.sixeyes.landofooo.block.CottonCandyBlock;
import net.sixeyes.landofooo.block.OozingBlock;
import net.sixeyes.landofooo.registry.ModBlocks;
import net.sixeyes.landofooo.registry.ModItems;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput generator) {
        super(generator);
    }

    public final void registerBottomCustomTopAndSide(BlockStateModelGenerator b, Block bottom, Block base) {
        TextureMap textureMap = (new TextureMap())
                .put(TextureKey.BOTTOM, TextureMap.getId(bottom))
                .put(TextureKey.TOP, TextureMap.getId(base))
                .put(TextureKey.SIDE, TextureMap.getSubId(base, "_side"));
        b.blockStateCollector.accept(
                BlockStateModelGenerator.createSingletonBlockState(base, Models.CUBE_BOTTOM_TOP.upload(base, textureMap, b.modelCollector)));
    }

    private void registerCottonCandyBlock(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(ModBlocks.COTTON_CANDY_BLOCK)
                        .coordinate(
                                BlockStateVariantMap.create(CottonCandyBlock.VOLUME)
                                        .register((Integer) 1, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.COTTON_CANDY_BLOCK, "1", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer) 2, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.COTTON_CANDY_BLOCK, "2", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register((Integer) 3, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        ModBlocks.COTTON_CANDY_BLOCK, "3", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                        )

        );
    }

    private void registerOozingBlock(BlockStateModelGenerator blockStateModelGenerator, Block block) {
        blockStateModelGenerator.blockStateCollector.accept(
                VariantsBlockStateSupplier.create(block)
                        .coordinate(
                                BlockStateVariantMap.create(OozingBlock.OOZING)
                                        .register(false, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        block, "_empty", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                                        .register(true, BlockStateVariant.create()
                                                .put(VariantSettings.MODEL, blockStateModelGenerator.createSubModel(
                                                        block, "_full", Models.CUBE_ALL, TextureMap::all)
                                                )
                                        )
                        )

        );
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CANDY_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONE_ROCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHOCOLATE_DIRT);
        registerBottomCustomTopAndSide(blockStateModelGenerator, ModBlocks.CHOCOLATE_DIRT, ModBlocks.FROSTED_CHOCOLATE_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FROSTING);
        blockStateModelGenerator.registerSimpleState(ModBlocks.BUTTERSCOTCH);

        blockStateModelGenerator.registerLog(ModBlocks.COTTON_CANDY_LOG)
                .log(ModBlocks.COTTON_CANDY_LOG).wood(ModBlocks.COTTON_CANDY_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_COTTON_CANDY_LOG)
                .log(ModBlocks.STRIPPED_COTTON_CANDY_LOG).wood(ModBlocks.STRIPPED_COTTON_CANDY_WOOD);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COTTON_CANDY_PLANKS)
                .button(ModBlocks.COTTON_CANDY_BUTTON)
                .stairs(ModBlocks.COTTON_CANDY_STAIRS)
                .slab(ModBlocks.COTTON_CANDY_SLAB)
                .fence(ModBlocks.COTTON_CANDY_FENCE)
                .fenceGate(ModBlocks.COTTON_CANDY_FENCE_GATE)
                .pressurePlate(ModBlocks.COTTON_CANDY_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.COTTON_CANDY_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.COTTON_CANDY_TRAPDOOR);
        registerCottonCandyBlock(blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SETTLED_SNOW);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEP_ICE);
        blockStateModelGenerator.registerCubeWithCustomTextures(ModBlocks.ICE_CRAFTING_TABLE,
                ModBlocks.DEEP_ICE, TextureMap::frontSideWithCustomBottom);
        blockStateModelGenerator.registerBed(ModBlocks.ICE_BED, ModBlocks.DEEP_ICE);
        blockStateModelGenerator.registerCooker(ModBlocks.ICE_FURNACE, TexturedModel.ORIENTABLE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEADSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEADSTONE);
        registerOozingBlock(blockStateModelGenerator, ModBlocks.OOZING_DEADSTONE);
        registerOozingBlock(blockStateModelGenerator, ModBlocks.OOZING_DEADSLATE);
        blockStateModelGenerator.registerSimpleState(ModBlocks.ACID);

        // spawn eggs
        blockStateModelGenerator.registerParentedItemModel(ModItems.PENGUIN_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.THE_LICH_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.ICE_KING_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ICE_CROWN, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUTTERSCOTCH_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COTTON_CANDY_ON_A_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ICE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ICE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ICE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ICE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ACID_BUCKET, Models.GENERATED);
    }
}
