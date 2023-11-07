package net.sixeyes.landofooo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.sixeyes.landofooo.registry.ModBlocks;
import net.sixeyes.landofooo.registry.ModItems;

public class ModBlockLootTables extends FabricBlockLootTableProvider {
    public ModBlockLootTables(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.CANDY_STONE, drops(ModBlocks.CANDY_STONE.asItem()));
        addDrop(ModBlocks.CONE_ROCK, drops(ModBlocks.CONE_ROCK.asItem()));
        addDrop(ModBlocks.CHOCOLATE_DIRT, drops(ModBlocks.CHOCOLATE_DIRT.asItem()));
        addDrop(ModBlocks.FROSTED_CHOCOLATE_DIRT, drops(ModBlocks.FROSTED_CHOCOLATE_DIRT.asItem()));
        addDrop(ModBlocks.FROSTING, drops(ModBlocks.FROSTING.asItem()));

        addDrop(ModBlocks.COTTON_CANDY_LOG, drops(ModBlocks.COTTON_CANDY_LOG.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_WOOD, drops(ModBlocks.COTTON_CANDY_WOOD.asItem()));
        addDrop(ModBlocks.STRIPPED_COTTON_CANDY_LOG, drops(ModBlocks.STRIPPED_COTTON_CANDY_LOG.asItem()));
        addDrop(ModBlocks.STRIPPED_COTTON_CANDY_WOOD, drops(ModBlocks.STRIPPED_COTTON_CANDY_WOOD.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_PLANKS, drops(ModBlocks.COTTON_CANDY_PLANKS.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_STAIRS, drops(ModBlocks.COTTON_CANDY_STAIRS.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_SLAB, drops(ModBlocks.COTTON_CANDY_SLAB.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_FENCE, drops(ModBlocks.COTTON_CANDY_FENCE.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_FENCE_GATE, drops(ModBlocks.COTTON_CANDY_FENCE_GATE.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_PRESSURE_PLATE, drops(ModBlocks.COTTON_CANDY_PRESSURE_PLATE.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_BUTTON, drops(ModBlocks.COTTON_CANDY_BUTTON.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_DOOR, drops(ModBlocks.COTTON_CANDY_DOOR.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_TRAPDOOR, drops(ModBlocks.COTTON_CANDY_TRAPDOOR.asItem()));
        addDrop(ModBlocks.COTTON_CANDY_BLOCK, drops(ModBlocks.COTTON_CANDY_BLOCK.asItem()));

        addDrop(ModBlocks.SETTLED_SNOW, drops(ModBlocks.SETTLED_SNOW.asItem()));
        addDrop(ModBlocks.DEEP_ICE, drops(ModBlocks.DEEP_ICE.asItem()));
        addDrop(ModBlocks.ICE_CRAFTING_TABLE, drops(ModBlocks.ICE_CRAFTING_TABLE.asItem()));
        addDrop(ModBlocks.ICE_FURNACE, drops(ModBlocks.ICE_FURNACE.asItem()));

        addDrop(ModBlocks.DEADSLATE, drops(ModBlocks.DEADSLATE.asItem()));
        addDrop(ModBlocks.DEADSTONE, drops(ModBlocks.DEADSTONE.asItem()));
        addDrop(ModBlocks.OOZING_DEADSLATE, drops(ModBlocks.OOZING_DEADSLATE.asItem()));
        addDrop(ModBlocks.OOZING_DEADSTONE, drops(ModBlocks.OOZING_DEADSTONE.asItem()));

    }
}
