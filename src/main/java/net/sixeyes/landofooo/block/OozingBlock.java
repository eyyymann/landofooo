package net.sixeyes.landofooo.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class OozingBlock extends Block {
    public static final BooleanProperty OOZING = BooleanProperty.of("oozing");

    public OozingBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(OOZING, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(OOZING);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return false;
        //return state.get(VOLUME) < 3;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            return;
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            return ActionResult.PASS;
        }
        return ActionResult.FAIL;
    }
}
