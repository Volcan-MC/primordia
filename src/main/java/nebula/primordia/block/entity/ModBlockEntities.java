package nebula.primordia.block.entity;

import nebula.primordia.Primordia;
import nebula.primordia.block.ModBlocks;
import nebula.primordia.block.entity.custom.ForgeBlockEntity;
import nebula.primordia.block.entity.custom.TableBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<TableBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Primordia.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(TableBlockEntity::new, ModBlocks.STONE_TABLE).build(null));

    public static final BlockEntityType<ForgeBlockEntity> FORGE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Primordia.MOD_ID, "growth_chamber_be"),
                    BlockEntityType.Builder.create(ForgeBlockEntity::new, ModBlocks.FORGE).build(null));

    public static void registerBlockEntities() {
        Primordia.LOGGER.info("Registering Block Entities for " + Primordia.MOD_ID);
    }
}