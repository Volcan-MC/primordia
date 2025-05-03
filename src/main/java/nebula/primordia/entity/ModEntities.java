package nebula.primordia.entity;

import nebula.primordia.Primordia;
import nebula.primordia.entity.custom.SurgeEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<SurgeEntity> SURGE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Primordia.MOD_ID, "surge"),
            EntityType.Builder.create(SurgeEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 2.5f).build());

    public static void registerModEntities() {
        Primordia.LOGGER.info("Registering Mod Entities for " + Primordia.MOD_ID);
    }
}