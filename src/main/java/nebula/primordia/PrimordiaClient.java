package nebula.primordia;

import nebula.primordia.block.ModBlocks;
import nebula.primordia.block.entity.ModBlockEntities;
import nebula.primordia.block.entity.renderer.TableBlockEntityRenderer;
import nebula.primordia.entity.ModEntities;
import nebula.primordia.entity.client.SurgeModel;
import nebula.primordia.entity.client.SurgeRenderer;
import nebula.primordia.screen.ModScreenHandlers;
import nebula.primordia.screen.custom.ForgeScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class PrimordiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILLOW_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STONE_TABLE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEARTHFLAME_ALTAR, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, TableBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.FORGE_SCREEN_HANDLER, ForgeScreen::new);

        EntityModelLayerRegistry.registerModelLayer(SurgeModel.SURGE, SurgeModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SURGE, SurgeRenderer::new);
    }
}
