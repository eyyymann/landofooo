package net.sixeyes.landofooo.item;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.sixeyes.landofooo.item.material.IceCrownMaterial;

public class IceCrownItem extends ArmorItem {

    private static final ArmorMaterial MATERIAL = new IceCrownMaterial();

    public IceCrownItem(Settings settings) {
        super(MATERIAL, Type.HELMET, settings);
    }
}
