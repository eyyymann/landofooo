package net.sixeyes.landofooo.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SettledSnowBlock extends Block {
    public SettledSnowBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (!world.isClient()) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = ((LivingEntity)entity);
                float maxHp = livingEntity.getMaxHealth();
                float curHp = livingEntity.getHealth();
                if (curHp < maxHp) {
                    livingEntity.setInPowderSnow(true);
                }
            }
        }
    }
}
