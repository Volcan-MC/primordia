package nebula.primordia.enchantment;

import nebula.primordia.Primordia;
import nebula.primordia.enchantment.custom.IceAspectEnchantmentEffect;
import nebula.primordia.enchantment.custom.PropulsionEnchantmentEffect;
import nebula.primordia.util.ModTags;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> PROPULSION =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Primordia.MOD_ID, "propulsion"));

    public static final RegistryKey<Enchantment> ICEASPECT =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Primordia.MOD_ID, "ice_aspect"));

    public static final RegistryKey<Enchantment> MAGNETISM =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Primordia.MOD_ID, "magnetism"));



    public static final RegistryKey<Enchantment> BLAZEFOOT =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Primordia.MOD_ID, "blazefoot"));

    public static final RegistryKey<Enchantment> VAMPIRISM =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Primordia.MOD_ID, "vampirism"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, PROPULSION, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ModTags.Items.GAUNTLET_ENCHANTMENT_TAG),
                        15,
                        1,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,

                        AttributeModifierSlot.MAINHAND))


                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new PropulsionEnchantmentEffect()));

        register(registerable, ICEASPECT, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
                        items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
                        15,
                        1,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,

                        AttributeModifierSlot.MAINHAND))

                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new IceAspectEnchantmentEffect()));
    }


    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}