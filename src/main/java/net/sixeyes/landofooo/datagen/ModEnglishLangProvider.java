package net.sixeyes.landofooo.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.util.Pair;
import net.sixeyes.landofooo.registry.ModBlocks;
import net.sixeyes.landofooo.registry.ModEntities;
import net.sixeyes.landofooo.registry.ModItems;
import net.sixeyes.landofooo.registry.ModStatusEffects;
import org.apache.commons.lang3.StringUtils;

public class ModEnglishLangProvider extends FabricLanguageProvider {

    public ModEnglishLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (Pair<String, Item> pair : ModItems.ITEMS) {
            String[] strings = pair.getLeft().split("\\_", 0);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = StringUtils.capitalize(strings[i]);
            }
            translationBuilder.add(pair.getRight(),
                    String.join(" ", strings));
        }

        for (Pair<String, Block> pair : ModBlocks.BLOCKS) {
            String[] strings = pair.getLeft().split("\\_", 0);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = StringUtils.capitalize(strings[i]);
            }
            translationBuilder.add(pair.getRight(),
                    String.join(" ", strings));
        }

        for (Pair<String, EntityType<?>> pair : ModEntities.ENTITIES) {
            String[] strings = pair.getLeft().split("\\_", 0);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = StringUtils.capitalize(strings[i]);
            }
            translationBuilder.add(pair.getRight(),
                    String.join(" ", strings));
        }

        for (Pair<String, StatusEffect> pair : ModStatusEffects.STATUS_EFFECTS) {
            String[] strings = pair.getLeft().split("\\_", 0);
            for (int i = 0; i < strings.length; i++) {
                strings[i] = StringUtils.capitalize(strings[i]);
            }
            translationBuilder.add(pair.getRight(),
                    String.join(" ", strings));
        }

        translationBuilder.add("itemgroup.items", "Land Of Ooo Items");
        translationBuilder.add("itemgroup.blocks", "Land of Ooo Blocks");
    }
}
