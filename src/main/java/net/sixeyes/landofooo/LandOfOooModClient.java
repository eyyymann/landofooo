package net.sixeyes.landofooo;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.sixeyes.landofooo.entity.model.PenguinEntityModel;
import net.sixeyes.landofooo.entity.renderer.IceKingEntityRenderer;
import net.sixeyes.landofooo.entity.renderer.PenguinEntityRenderer;
import net.sixeyes.landofooo.entity.renderer.TheLichEntityRenderer;
import net.sixeyes.landofooo.registry.ModBlocks;
import net.sixeyes.landofooo.registry.ModEntities;
import net.sixeyes.landofooo.registry.ModFluids;

public class LandOfOooModClient implements ClientModInitializer {

    public static final EntityModelLayer MODEL_CUBE_LAYER = new EntityModelLayer(new Identifier(LandOfOooMod.MOD_ID, "cube"), "main");

    @Override
    public void onInitializeClient() {
        initializeBlocks();
        initializeFluids();
        initializeEntities();
    }

    private void initializeFluids() {
        // Butterscotch client side registration
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_BUTTERSCOTCH, ModFluids.FLOWING_BUTTERSCOTCH,
                new SimpleFluidRenderHandler(
                        new Identifier("landofooo:block/butterscotch_still"),
                        new Identifier("landofooo:block/butterscotch_flow"),
                        0xf5c248
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_BUTTERSCOTCH, ModFluids.FLOWING_BUTTERSCOTCH);

        // Acid client side registration CHANGE THIS TO ACID TEXTURES
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_ACID, ModFluids.FLOWING_ACID,
                new SimpleFluidRenderHandler(
                        new Identifier("landofooo:block/acid_still"),
                        new Identifier("landofooo:block/acid_flow"),
                        0xf5c248
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_ACID, ModFluids.FLOWING_ACID);
    }

    private void initializeBlocks() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COTTON_CANDY_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COTTON_CANDY_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ICE_BED, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEP_ICE, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COTTON_CANDY_BLOCK, RenderLayer.getCutout());
    }

    private void initializeEntities() {
        EntityRendererRegistry.register(ModEntities.PENGUIN, PenguinEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.THE_LICH, TheLichEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.ICE_KING, IceKingEntityRenderer::new);
    }
}
