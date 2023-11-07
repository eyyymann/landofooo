package net.sixeyes.landofooo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sixeyes.landofooo.registry.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    private static final TagKey<Block> CANDY_BLOCKS = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("landofooo:candy_blocks"));
    private static final TagKey<Block> COTTON_CANDY_WOOD = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("landofooo:cotton_candy_wood"));
    private static final TagKey<Block> ICE_BLOCKS = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("landofooo:ice_blocks"));
    private static final TagKey<Block> MAGIC_BLOCKS = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("landofooo:magic_blocks"));
    private static final TagKey<Block> RUIN_SOLID_BLOCKS = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("landofooo:ruin_solid_blocks"));
    private static final TagKey<Block> RUIN_BLOCKS = TagKey.of(
            RegistryKeys.BLOCK, new Identifier("landofooo:ruin_blocks"));

    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        // CANDY BLOCKS
        getOrCreateTagBuilder(COTTON_CANDY_WOOD)
                .add(ModBlocks.COTTON_CANDY_LOG)
                .add(ModBlocks.COTTON_CANDY_WOOD)
                .add(ModBlocks.STRIPPED_COTTON_CANDY_LOG)
                .add(ModBlocks.STRIPPED_COTTON_CANDY_WOOD)
                .add(ModBlocks.COTTON_CANDY_PLANKS)
                .add(ModBlocks.COTTON_CANDY_STAIRS)
                .add(ModBlocks.COTTON_CANDY_SLAB)
                .add(ModBlocks.COTTON_CANDY_BUTTON)
                .add(ModBlocks.COTTON_CANDY_DOOR)
                .add(ModBlocks.COTTON_CANDY_TRAPDOOR)
                .add(ModBlocks.COTTON_CANDY_FENCE)
                .add(ModBlocks.COTTON_CANDY_FENCE_GATE)
                .add(ModBlocks.COTTON_CANDY_PRESSURE_PLATE);

        getOrCreateTagBuilder(CANDY_BLOCKS)
                .add(ModBlocks.CANDY_STONE)
                .add(ModBlocks.CONE_ROCK)
                .add(ModBlocks.CHOCOLATE_DIRT)
                .add(ModBlocks.FROSTED_CHOCOLATE_DIRT)
                .add(ModBlocks.FROSTING)
                .addTag(COTTON_CANDY_WOOD)
                .add(ModBlocks.COTTON_CANDY_BLOCK);

        // ICE BLOCKS
        getOrCreateTagBuilder(ICE_BLOCKS)
                .add(Blocks.ICE)
                .add(Blocks.PACKED_ICE)
                .add(Blocks.BLUE_ICE)
                .add(ModBlocks.SETTLED_SNOW)
                .add(ModBlocks.DEEP_ICE)
                .add(ModBlocks.ICE_CRAFTING_TABLE);

        // RUIN SOLID BLOCKS
        getOrCreateTagBuilder(RUIN_SOLID_BLOCKS)
                .add(ModBlocks.DEADSLATE)
                .add(ModBlocks.DEADSTONE)
                .add(ModBlocks.OOZING_DEADSLATE)
                .add(ModBlocks.OOZING_DEADSTONE)
        ;

        // RUIN BLOCKS
        getOrCreateTagBuilder(RUIN_BLOCKS)
                .addTag(RUIN_SOLID_BLOCKS)
                .add(ModBlocks.ACID)
        ;

        // MAGIC BLOCKS
        getOrCreateTagBuilder(MAGIC_BLOCKS)
                .addTag(CANDY_BLOCKS)
                .addTag(ICE_BLOCKS)
                .addTag(RUIN_BLOCKS);

        // NEEDS STONE TOOLS
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.CONE_ROCK)
                .add(ModBlocks.SETTLED_SNOW)
                .add(ModBlocks.CONE_ROCK)
                .addTag(RUIN_SOLID_BLOCKS)
        ;

        // NEEDS AXES
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .addTag(COTTON_CANDY_WOOD);

        // NEEDS PICKAXES
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CANDY_STONE)
                .add(ModBlocks.CONE_ROCK)
                .addTag(RUIN_SOLID_BLOCKS);

        // NEEDS SHOVELS
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.CHOCOLATE_DIRT)
                .add(ModBlocks.FROSTED_CHOCOLATE_DIRT)
                .add(ModBlocks.FROSTING)
                .add(ModBlocks.SETTLED_SNOW);

        // NEEDS HOES
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.COTTON_CANDY_BLOCK);

        //WOODSET TAGS
        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(ModBlocks.COTTON_CANDY_LOG)
            .add(ModBlocks.STRIPPED_COTTON_CANDY_LOG)
            .add(ModBlocks.STRIPPED_COTTON_CANDY_WOOD)
            .add(ModBlocks.STRIPPED_COTTON_CANDY_LOG);
        getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.COTTON_CANDY_BLOCK);
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.COTTON_CANDY_PLANKS);
        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.COTTON_CANDY_STAIRS);
        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.COTTON_CANDY_SLAB);
        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.COTTON_CANDY_DOOR);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.COTTON_CANDY_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.COTTON_CANDY_BUTTON);
        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.COTTON_CANDY_PRESSURE_PLATE);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.COTTON_CANDY_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.COTTON_CANDY_FENCE_GATE);

//        // WALLS
//        getOrCreateTagBuilder(BlockTags.WALLS)
//                .add(ModBlocks.EPILITE_WALL)
//                .add(ModBlocks.MARBASE_WALL);
    }
}
