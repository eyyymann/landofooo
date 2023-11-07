package net.sixeyes.landofooo.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.sixeyes.landofooo.LandOfOooMod;
import net.sixeyes.landofooo.block.*;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    // LIST OF BLOCKS
    public static List<Pair<String, Block>> BLOCKS = new ArrayList<>();

    // RANDOM BLOCKS

    // CANDY KINGDOM BLOCKS
    public static Block BUTTERSCOTCH = registerBlockBare("butterscotch", new FluidBlock(
            ModFluids.STILL_BUTTERSCOTCH, FabricBlockSettings.copy(Blocks.WATER).liquid()){});
    public static final Block CANDY_STONE = registerBlock("candy_stone", new Block(
            FabricBlockSettings.copyOf(Blocks.END_STONE)));
    public static final Block CONE_ROCK = registerBlock("cone_rock", new Block(
            FabricBlockSettings.copyOf(Blocks.BLACKSTONE)));
    public static final Block CHOCOLATE_DIRT = registerBlock("chocolate_dirt", new Block(
            FabricBlockSettings.copyOf(Blocks.DIRT)));
    public static final Block FROSTED_CHOCOLATE_DIRT = registerBlock("frosted_chocolate_dirt", new Block(
            FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK)));
    public static final Block FROSTING = registerBlock("frosting", new Block(
            FabricBlockSettings.copyOf(Blocks.SCULK)));
    public static final BlockSetType COTTON_CANDY_BLOCK_SET = new BlockSetType("cotton_candy");
    public static final WoodType COTTON_CANDY = new WoodType("cotton_candy", COTTON_CANDY_BLOCK_SET);
    public static final Block COTTON_CANDY_LOG = registerBlock("cotton_candy_log", Blocks.createLogBlock(
            MapColor.WHITE, MapColor.DULL_PINK));
    public static final Block COTTON_CANDY_WOOD = registerBlock("cotton_candy_wood",
            Blocks.createLogBlock(MapColor.WHITE, MapColor.DULL_PINK));
    public static final Block STRIPPED_COTTON_CANDY_LOG = registerBlock("stripped_cotton_candy_log",
            Blocks.createLogBlock(MapColor.WHITE, MapColor.DULL_PINK));
    public static final Block STRIPPED_COTTON_CANDY_WOOD = registerBlock("stripped_cotton_candy_wood",
            Blocks.createLogBlock(MapColor.WHITE, MapColor.DULL_PINK));
    public static final Block COTTON_CANDY_PLANKS = registerBlock("cotton_candy_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS)));
    public static final Block COTTON_CANDY_STAIRS = registerBlock("cotton_candy_stairs",
            new StairsBlock(COTTON_CANDY_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(COTTON_CANDY_PLANKS)));
    public static final Block COTTON_CANDY_SLAB = registerBlock("cotton_candy_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_SLAB)));
    public static final Block COTTON_CANDY_FENCE = registerBlock("cotton_candy_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE)));
    public static final Block COTTON_CANDY_FENCE_GATE = registerBlock("cotton_candy_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_FENCE_GATE), COTTON_CANDY));
    public static final Block COTTON_CANDY_PRESSURE_PLATE = registerBlock("cotton_candy_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.CHERRY_PRESSURE_PLATE), COTTON_CANDY_BLOCK_SET));
    public static final Block COTTON_CANDY_BUTTON = registerBlock("cotton_candy_button",
            Blocks.createWoodenButtonBlock(COTTON_CANDY_BLOCK_SET));
    public static final Block COTTON_CANDY_DOOR = registerBlock("cotton_candy_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_DOOR), COTTON_CANDY_BLOCK_SET));
    public static final Block COTTON_CANDY_TRAPDOOR = registerBlock("cotton_candy_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.CHERRY_TRAPDOOR), COTTON_CANDY_BLOCK_SET));
    public static final Block COTTON_CANDY_BLOCK = registerBlock("cotton_candy_block", new CottonCandyBlock(
            FabricBlockSettings.copyOf(Blocks.CHERRY_LEAVES)));

    // ICE KINGDOM
    public static final Block SETTLED_SNOW = registerBlock("settled_snow", new SettledSnowBlock(
            FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK)));
    public static final Block DEEP_ICE = registerBlock("deep_ice", new Block(
            FabricBlockSettings.copyOf(Blocks.BLUE_ICE).strength(1F, 2.0F)));
    public static final Block ICE_CRAFTING_TABLE = registerBlock("ice_crafting_table", new IceCraftingTableBlock(
            FabricBlockSettings.copyOf(Blocks.BLUE_ICE).strength(1F, 2.0F)));
    public static final Block ICE_FURNACE = registerBlock("ice_furnace", new IceFurnaceBlock(
            FabricBlockSettings.copyOf(Blocks.BLUE_ICE).strength(1.5F, 2.0F)));
    public static final Block ICE_BED = registerBlockNoCreative("ice_bed", new BedBlock(DyeColor.CYAN, AbstractBlock.Settings.create().mapColor((state) -> {
        return state.get(BedBlock.PART) == BedPart.FOOT ? DyeColor.CYAN.getMapColor() : MapColor.WHITE_GRAY;
    }).sounds(BlockSoundGroup.WOOD).strength(0.2F).nonOpaque().slipperiness(0.999F).burnable().pistonBehavior(PistonBehavior.DESTROY)));

    // RUINED CITY
    public static final Block DEADSLATE = registerBlock("deadslate", new Block(
            FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block DEADSTONE = registerBlock("deadstone", new Block(
            FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block OOZING_DEADSLATE = registerBlock("oozing_deadslate", new OozingBlock(
            FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static final Block OOZING_DEADSTONE = registerBlock("oozing_deadstone", new OozingBlock(
            FabricBlockSettings.copyOf(Blocks.DEEPSLATE)));
    public static Block ACID = registerBlockBare("acid", new FluidBlock(
            ModFluids.STILL_ACID, FabricBlockSettings.copy(Blocks.LAVA).liquid()){});

    // METHODS
    private static Block registerBlockBare(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(LandOfOooMod.MOD_ID, name), block);
    }

    private static Block registerBlockNoCreative(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(LandOfOooMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        BLOCKS.add(new Pair<>(name, block));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(LandOfOooMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(LandOfOooMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    private static BedBlock createBedBlock(DyeColor color) {
        return new BedBlock(color, AbstractBlock.Settings.create().mapColor((state) -> {
            return state.get(BedBlock.PART) == BedPart.FOOT ? color.getMapColor() : MapColor.WHITE_GRAY;
        }).sounds(BlockSoundGroup.WOOD).strength(0.2F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    }

    public static void registerBlocks() {

        LandOfOooMod.LOGGER.info("Registering Mod Blocks " + LandOfOooMod.MOD_ID);
    }
}
