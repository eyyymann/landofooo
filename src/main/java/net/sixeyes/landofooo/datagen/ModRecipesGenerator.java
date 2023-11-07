package net.sixeyes.omnitrixorigins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.sixeyes.omnitrixorigins.registry.ModBlocks;
import net.sixeyes.omnitrixorigins.registry.ModItems;

public class ModRecipesGenerator extends FabricRecipeProvider {

    public ModRecipesGenerator(FabricDataOutput generator) {
        super(generator);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // remake all the other things
    }
}
