package nebula.primordia;

import nebula.primordia.block.ModBlocks;
import nebula.primordia.block.entity.ModBlockEntities;
import nebula.primordia.block.entity.renderer.TableBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class PrimordiaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALE_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STONE_TABLE, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, TableBlockEntityRenderer::new);
    }
}
