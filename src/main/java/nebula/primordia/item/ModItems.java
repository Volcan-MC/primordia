package nebula.primordia.item;

import nebula.primordia.block.ModBlocks;
import nebula.primordia.item.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import nebula.primordia.Primordia;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
        public static final Item TATTERED_CLOTH = registerItem("tattered_cloth", new Item(new Item.Settings()));

    public static final Item STARTER_POUCH = registerItem("starter_pouch", new PouchItem(new Item.Settings()));

    public static final Item BASIC_WATERSKIN = registerItem("basic_waterskin", new WaterskinItem(new Item.Settings()));

    public static final Item CLOAKING_TALISMAN = registerItem("cloaking_talisman", new TalismanItem(new Item.Settings().maxCount(1)));

        public static final Item BROKEN_SWORD = registerItem("broken_sword", new BrokenSwordItem(new Item.Settings()));

    public static final Item ITEM = registerItem("item", new Item(new Item.Settings()));
        public static final Item TATTERED_PICKAXE = registerItem("tattered_pickaxe",
                new PickaxeItem(ModToolMaterials.TATTERED, new Item.Settings()
                        .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TATTERED, 1, -2.8f))));

    public static final Item STORMWEAVER = registerItem("stormweaver",
            new StormWeaverItem(ModToolMaterials.STORM, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STORM, 6, -3.2f))));

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



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Primordia.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Primordia.LOGGER.info("Registering Mod Items for " + Primordia.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(entries -> {
            entries.add(STORMWEAVER);
        });
    }
}