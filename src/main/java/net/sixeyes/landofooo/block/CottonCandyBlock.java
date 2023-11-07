package net.sixeyes.landofooo.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.sixeyes.landofooo.registry.ModItems;

public class CottonCandyBlock extends Block {

    public static final IntProperty VOLUME = IntProperty.of("volume",1,3);
    public static final BooleanProperty NATURAL = BooleanProperty.of("natural");

    public CottonCandyBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(VOLUME, 3).with(NATURAL, true));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VOLUME).add(NATURAL);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return state.get(VOLUME) < 3;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            int i = state.get(VOLUME);
            boolean j = state.get(NATURAL);
            int r = random.nextBetween(1,100);
            if (r > 90) {
                world.setBlockState(pos, state.with(VOLUME, i+1), Block.NOTIFY_LISTENERS);
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient()) {
            int volume = state.get(VOLUME);
            ItemStack inHand = player.getStackInHand(hand);

            if (inHand.isOf(Items.STICK) && volume > 1) {
                world.setBlockState(pos, state.with(VOLUME, volume-1), Block.NOTIFY_LISTENERS);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(player, state.with(VOLUME, volume-1)));
                player.setStackInHand(hand, new ItemStack(Items.STICK, inHand.getCount()-1));
                player.giveItemStack(new ItemStack(ModItems.COTTON_CANDY_ON_A_STICK, 1));
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    public VoxelShape getSidesShape(BlockState state, BlockView world, BlockPos pos) {
        return VoxelShapes.empty();
    }

    public int getOpacity(BlockState state, net.minecraft.world.BlockView world, BlockPos pos) {
        return 1;
    }
}
