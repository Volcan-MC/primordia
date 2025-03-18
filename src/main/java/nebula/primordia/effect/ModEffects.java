package nebula.primordia.effect;

import nebula.primordia.Primordia;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> BLEEDING = registerStatusEffect("bleed",
            new BleedingEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Primordia.MOD_ID, "bleed"), 0.0f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> FREEZING = registerStatusEffect("freezing",
            new FreezingEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Primordia.MOD_ID, "bleed"), -1.5f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryEntry<StatusEffect> CLOAKING = registerStatusEffect("cloaking",
            new CloakingEffect(StatusEffectCategory.NEUTRAL, 0x36ebab)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Primordia.MOD_ID, "bleed"), 0.0f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Primordia.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Primordia.LOGGER.info("Registering Mod Effects for " + Primordia.MOD_ID);
    }
}