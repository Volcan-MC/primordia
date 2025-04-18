package nebula.primordia.item;

import nebula.primordia.Primordia;
import nebula.primordia.block.ModBlocks;
import nebula.primordia.entity.ModEntities;
import nebula.primordia.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
        public static final Item TATTERED_CLOTH = registerItem("tattered_cloth", new Item(new Item.Settings()));

    public static final Item STARTER_POUCH = registerItem("starter_pouch", new PouchItem(new Item.Settings()));

    public static final Item BASIC_WATERSKIN = registerItem("basic_waterskin", new WaterskinItem(new Item.Settings()));


    public static final Item CLOAKING_TALISMAN = registerItem("cloaking_talisman", new TalismanItem(new Item.Settings().rarity(Rarity.EPIC)));

        public static final Item BROKEN_SWORD = registerItem("broken_sword", new BrokenSwordItem(new Item.Settings()));

    public static final Item ITEM = registerItem("item", new Item(new Item.Settings()));
        public static final Item TATTERED_PICKAXE = registerItem("tattered_pickaxe",
                new PickaxeItem(ModToolMaterials.TATTERED, new Item.Settings()
                        .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TATTERED, 1, -2.8f))));

    public static final Item STORMWEAVER = registerItem("stormweaver",
            new StormWeaverItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f)).rarity(Rarity.EPIC)));

    public static final Item FLINT_KNIFE = registerItem("flint_knife",
            new SwordItem(ModToolMaterials.TATTERED, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TATTERED, -3, -2.6f))));

    public static final Item TATTERED_AXE = registerItem("tattered_axe",
            new AxeItem(ModToolMaterials.TATTERED, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TATTERED, 1, -2.8f))));

    public static final Item FLINT_SPEAR = registerItem("flint_spear",
            new SwordItem(ModToolMaterials.TATTERED, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TATTERED, 0, -2.2f))));

    public static final Item SALMON_STICK = registerItem("salmon_stick",
            new AliasedBlockItem(ModBlocks.FISH_STICK, new Item.Settings().food(ModFoodComponents.STICK_OF_FISH)));

    public static final Item COOKED_SALMON_STICK = registerItem("cooked_salmon_stick",
            new AliasedBlockItem(ModBlocks.FISH_STICK, new Item.Settings().food(ModFoodComponents.STICK_OF_FISH_COOKED)));

    public static final Item COD_STICK = registerItem("cod_stick",
            new AliasedBlockItem(ModBlocks.FISH_STICK, new Item.Settings().food(ModFoodComponents.STICK_OF_FISH)));

    public static final Item COOKED_COD_STICK = registerItem("cooked_cod_stick",
            new AliasedBlockItem(ModBlocks.FISH_STICK, new Item.Settings().food(ModFoodComponents.STICK_OF_FISH_COOKED)));

    public static final Item TROPICAL_FISH_STICK = registerItem("tropical_fish_stick",
            new AliasedBlockItem(ModBlocks.FISH_STICK, new Item.Settings().food(ModFoodComponents.STICK_OF_FISH)));

    public static final Item SURVIVOR_HELMET = registerItem("survivors_helmet",
            new ArmorItem(ModArmorMaterials.SURVIVOR_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item SURVIVOR_CHESTPLATE = registerItem("survivors_chestplate",
            new ArmorItem(ModArmorMaterials.SURVIVOR_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item SURVIVOR_LEGGINGS = registerItem("survivors_leggings",
            new ArmorItem(ModArmorMaterials.SURVIVOR_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item SURVIVOR_BOOTS = registerItem("survivors_boots",
            new ArmorItem(ModArmorMaterials.SURVIVOR_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));


    public static final Item SUMMONERS_CODEX = registerItem("summoners_codex", new Item(new Item.Settings()));

    public static final Item REVERBIUM_GAUNTLET = registerItem("reverbium_gauntlet",
            new ReverbiumGauntletItem(ModToolMaterials.TATTERED, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TATTERED, 4, -2.6f)).rarity(Rarity.UNCOMMON).component(ModItemComponents.DASH_CAP,0)));



    public static final Item DIAMOND_REINFORCER = registerItem("diamond_reinforcer", new Item(new Item.Settings()));
    public static final Item DIAMOND_SWORD_HEAD = registerItem("diamond_sword_head", new Item(new Item.Settings()));
    public static final Item DIAMOND_SHOVEL_HEAD = registerItem("diamond_shovel_head", new Item(new Item.Settings()));
    public static final Item DIAMOND_HOE_HEAD = registerItem("diamond_hoe_head", new Item(new Item.Settings()));
    public static final Item DIAMOND_AXE_HEAD = registerItem("diamond_axe_head", new Item(new Item.Settings()));

    public static final Item REVERBIUM_HELMET = registerItem("reverbium_helmet", new ReverbiumHelmetItem(new Item.Settings()));

    public static final Item REVERBIUM_CHESTPLATE = registerItem("reverbium_chestplate",
            new ArmorItem(ModArmorMaterials.REVERB_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));

    public static final Item REVERBIUM_LEGGINGS = registerItem("reverbium_leggings",
            new ArmorItem(ModArmorMaterials.REVERB_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item REVERBIUM_BOOTS = registerItem("reverbium_boots",
            new ArmorItem(ModArmorMaterials.REVERB_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item REVERBIUM_INGOT = registerItem("reverbium_ingot", new Item(new Item.Settings().rarity(Rarity.UNCOMMON)));

    public static final Item PRIMORDIAL_LONGSWORD = registerItem("primordial_longsword",
            new PrimordialLongswordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item IRON_LONGSWORD = registerItem("iron_longsword",
            new LongswordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item GOLD_LONGSWORD = registerItem("gold_longsword",
            new LongswordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item DIAMOND_LONGSWORD = registerItem("diamond_longsword",
            new LongswordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item NETHERITE_LONGSWORD = registerItem("netherite_longsword",
            new LongswordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item IRON_DAGGER = registerItem("iron_dagger",
            new SwordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item GOLD_DAGGER = registerItem("gold_dagger",
            new SwordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item DIAMOND_DAGGER = registerItem("diamond_dagger",
            new SwordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

    public static final Item NETHERITE_DAGGER = registerItem("netherite_dagger",
            new SwordItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));


    public static final Item BOTTLE_OF_ECHOED_SOULS = registerItem("bottle_of_echoed_souls", new Item(new Item.Settings().rarity(Rarity.RARE)));

    public static final Item SURGE_SPAWN_EGG = registerItem("surge_spawn_egg",
            new SpawnEggItem(ModEntities.SURGE, 1001033, 7237230, new Item.Settings()));

    //public static final Item SURGE_CHARGE = registerItem("surge_charge", new SurgeChargeItem(new Item.Settings().rarity(Rarity.UNCOMMON)));

    public static final Item STORM_TRIAL_KEY = registerItem("storm_trial_key", new Item(new Item.Settings()));

    public static final Item BOOK_OF_BLOOD_MANIPULATION = registerItem("book_of_blood_manipulation", new Item(new Item.Settings().maxCount(1)));

    public static final Item SWORD_CAST_NORMAL = registerItem("sword_cast_normal", new NormalSwordCastItem(new Item.Settings().maxCount(16)));

    public static final Item SWORD_CAST_LONGSWORD = registerItem("sword_cast_longsword", new LongSwordCastItem(new Item.Settings().maxCount(16)));

    public static final Item SWORD_CAST_ZWEIHANDER = registerItem("sword_cast_zweihander", new ZweihanderCastItem(new Item.Settings().maxCount(16)));

    public static final Item SWORD_CAST_DAGGER = registerItem("sword_cast_dagger", new DaggerCastItem(new Item.Settings().maxCount(16)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Primordia.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Primordia.LOGGER.info("Registering Mod Items for " + Primordia.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> {
            entries.add(STORMWEAVER);
            entries.add(STORM_TRIAL_KEY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(SURGE_SPAWN_EGG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BOTTLE_OF_ECHOED_SOULS);
            entries.add(REVERBIUM_INGOT);
        });
    }

    private static Primordia nameTailor;
}