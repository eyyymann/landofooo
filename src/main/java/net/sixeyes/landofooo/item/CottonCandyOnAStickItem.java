package net.sixeyes.landofooo.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class CottonCandyOnAStickItem extends Item {
    public static final FoodComponent COTTON_CANDY_ON_A_STICK = new FoodComponent.Builder().hunger(5).saturationModifier(1.0f).alwaysEdible().build();

    public CottonCandyOnAStickItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack itemStack = super.finishUsing(stack, world, user);
        if (!world.isClient()) {
            if (user instanceof PlayerEntity p) {
                p.giveItemStack(new ItemStack(Items.STICK, 1));
            }
        }
        return itemStack;
    }
}
