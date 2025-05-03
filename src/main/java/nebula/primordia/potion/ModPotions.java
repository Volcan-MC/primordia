package nebula.primordia.potion;

import nebula.primordia.Primordia;
import nebula.primordia.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> HYPOTHERMIA_POTION = registerPotion("hypothermia_potion",
            new Potion(new StatusEffectInstance(ModEffects.FREEZING, 960, 0)));

    public static final RegistryEntry<Potion> DECAY_POTION = registerPotion("decay_potion",
            new Potion(new StatusEffectInstance(StatusEffects.WITHER, 960, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Primordia.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        Primordia.LOGGER.info("Registering Mod Potions for " + Primordia.MOD_ID);
    }
}