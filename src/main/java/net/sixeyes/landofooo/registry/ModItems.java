package net.sixeyes.landofooo.registry;

import net.minecraft.item.*;
import net.minecraft.util.Pair;
import net.sixeyes.landofooo.LandOfOooMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sixeyes.landofooo.block.CottonCandyBlock;
import net.sixeyes.landofooo.item.CottonCandyOnAStickItem;
import net.sixeyes.landofooo.item.IceCrownItem;
import net.sixeyes.landofooo.item.material.IceToolMaterial;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    // LIST OF BLOCKS
    public static List<Pair<String, Item>> ITEMS = new ArrayList<>();

    public static Item BUTTERSCOTCH_BUCKET = registerItem("butterscotch_bucket",
            new BucketItem(ModFluids.STILL_BUTTERSCOTCH, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));
    public static final Item COTTON_CANDY_ON_A_STICK = registerItem(
            "cotton_candy_on_a_stick", new CottonCandyOnAStickItem(new Item.Settings()
                    .food(CottonCandyOnAStickItem.COTTON_CANDY_ON_A_STICK)));

    public static final Item ICE_CROWN = registerItem("ice_crown", new IceCrownItem(
            new Item.Settings().maxCount(1)));
    public static final Item ICE_SHARD = registerItem("ice_shard", new Item(new FabricItemSettings()));
    public static Item ICE_PICKAXE = registerItem("ice_pickaxe",
            new PickaxeItem(IceToolMaterial.MATERIAL, 1, -2.8F, new FabricItemSettings()));
    public static Item ICE_HOE = registerItem("ice_hoe",
            new HoeItem(IceToolMaterial.MATERIAL, 4, -2.8F, new FabricItemSettings()));
    public static Item ICE_AXE = registerItem("ice_axe",
            new AxeItem(IceToolMaterial.MATERIAL, 5, -2.8F, new FabricItemSettings()));
    public static Item ICE_SHOVEL = registerItem("ice_shovel",
            new ShovelItem(IceToolMaterial.MATERIAL, 3, -2.8F, new FabricItemSettings()));

    // RUINED CITY
    public static Item ACID_BUCKET = registerItem("acid_bucket",
            new BucketItem(ModFluids.STILL_ACID, new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)));

    // SPAWN EGGS
    public static Item PENGUIN_SPAWN_EGG = registerItem("penguin_spawn_egg", new SpawnEggItem(ModEntities.PENGUIN, 0x01040F, 0xEEF3FF , new FabricItemSettings().maxCount(64)));
    public static Item THE_LICH_SPAWN_EGG = registerItem("the_lich_spawn_egg", new SpawnEggItem(ModEntities.THE_LICH, 0x79918B, 0x24302D , new FabricItemSettings().maxCount(64)));
    public static Item ICE_KING_SPAWN_EGG = registerItem("ice_king_spawn_egg", new SpawnEggItem(ModEntities.ICE_KING, 0xFDFDFA, 0x1010EE , new FabricItemSettings().maxCount(64)));

    private static Item registerItem(String name, Item item) {
        ITEMS.add(new Pair<>(name, item));
        return Registry.register(Registries.ITEM, new Identifier(LandOfOooMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LandOfOooMod.LOGGER.info("Registering Mod Items for " + LandOfOooMod.MOD_ID);
    }
}
