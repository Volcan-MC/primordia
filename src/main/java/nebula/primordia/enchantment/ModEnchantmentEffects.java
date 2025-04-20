package nebula.primordia.enchantment;

import com.mojang.serialization.MapCodec;
import nebula.primordia.Primordia;

import nebula.primordia.enchantment.custom.IceAspectEnchantmentEffect;
import nebula.primordia.enchantment.custom.MagnetismEnchantmentEffect;
import nebula.primordia.enchantment.custom.PropulsionEnchantmentEffect;
import nebula.primordia.enchantment.custom.VampirismEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> PROPULSION =
            registerEntityEffect("propulsion", PropulsionEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> ICEASPECT =
            registerEntityEffect("ice_aspect", IceAspectEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> MAGNETISM =
            registerEntityEffect("magnetism", MagnetismEnchantmentEffect.CODEC);



    public static final MapCodec<? extends EnchantmentEntityEffect> VAMPIRISM =
            registerEntityEffect("vampirism", VampirismEnchantmentEffect.CODEC);
//VOLCAN FIX THIS

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Primordia.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        Primordia.LOGGER.info("Registering Mod Enchantment Effects for " + Primordia.MOD_ID);
    }
}