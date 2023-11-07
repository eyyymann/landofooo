package net.sixeyes.landofooo.block.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;
import net.sixeyes.landofooo.registry.ModBlocks;
import net.sixeyes.landofooo.registry.ModFluids;
import net.sixeyes.landofooo.registry.ModItems;

public abstract class ButterscotchFluid extends AbstractCandyFluid {
        @Override
        public Fluid getStill() {
            return ModFluids.STILL_BUTTERSCOTCH;
        }

        @Override
        public Fluid getFlowing() {
            return ModFluids.FLOWING_BUTTERSCOTCH;
        }

        @Override
        public Item getBucketItem() {
            return ModItems.BUTTERSCOTCH_BUCKET;
        }

        @Override
        protected BlockState toBlockState(FluidState fluidState) {
            return ModBlocks.BUTTERSCOTCH.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
        }

        public static class Flowing extends ButterscotchFluid {
            @Override
            protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
                super.appendProperties(builder);
                builder.add(LEVEL);
            }

            @Override
            protected boolean isInfinite(World world) {
                return false;
            }

            @Override
            public int getLevel(FluidState fluidState) {
                return fluidState.get(LEVEL);
            }

            @Override
            public boolean isStill(FluidState fluidState) {
                return false;
            }
        }

        public static class Still extends ButterscotchFluid {
            @Override
            protected boolean isInfinite(World world) {
                return false;
            }

            @Override
            public int getLevel(FluidState fluidState) {
                return 8;
            }

            @Override
            public boolean isStill(FluidState fluidState) {
                return true;
            }
        }
}
