package nebula.primordia.item;

import nebula.primordia.Primordia;
import nebula.primordia.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup PRIMORDIA = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Primordia.MOD_ID, "primordia"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BROKEN_SWORD))
                    .displayName(Text.translatable("itemgroup.primordia.primordia"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TATTERED_CLOTH);
                        entries.add(ModItems.BROKEN_SWORD);
                        entries.add(ModItems.TATTERED_AXE);
                        entries.add(ModItems.TATTERED_PICKAXE);
                        entries.add(ModItems.SURVIVOR_HELMET);
                        entries.add(ModItems.SURVIVOR_CHESTPLATE);
                        entries.add(ModItems.SURVIVOR_LEGGINGS);
                        entries.add(ModItems.SURVIVOR_BOOTS);
                        entries.add(ModItems.STARTER_POUCH);
                        entries.add(ModItems.BASIC_WATERSKIN);
                        entries.add(ModBlocks.WILLOW_LOG);
                        entries.add(ModBlocks.WILLOW_WOOD);
                        entries.add(ModBlocks.STRIPPED_WILLOW_LOG);
                        entries.add(ModBlocks.STRIPPED_WILLOW_WOOD);
                        entries.add(ModBlocks.WILLOW_PLANKS);
                        entries.add(ModBlocks.WILLOW_STAIRS);
                        entries.add(ModBlocks.WILLOW_SLAB);
                        entries.add(ModBlocks.WILLOW_DOOR);
                        entries.add(ModBlocks.WILLOW_TRAPDOOR);
                        entries.add(ModBlocks.WILLOW_PRESSURE_PLATE);
                        entries.add(ModBlocks.WILLOW_BUTTON);
                        entries.add(ModItems.CLOAKING_TALISMAN);
                        entries.add(ModItems.FLINT_KNIFE);
                        entries.add(ModItems.FLINT_SPEAR);
                        entries.add(ModItems.SALMON_STICK);
                        entries.add(ModItems.COOKED_SALMON_STICK);
                        entries.add(ModItems.COD_STICK);
                        entries.add(ModItems.COOKED_COD_STICK);
                        entries.add(ModItems.TROPICAL_FISH_STICK);
                    }).build());

    public static final ItemGroup PRIMORDIA_DECOR = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Primordia.MOD_ID, "primordia_decor"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.STONE_TABLE))
                    .displayName(Text.translatable("itemgroup.primordia.primordia.decor"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.STONE_TABLE);
                        entries.add(ModBlocks.FORGE);
                        entries.add(ModBlocks.FORGE_BRICKS);
                    }).build());
    public static void registerItemGroups() {
        Primordia.LOGGER.info("Registering Item Groups for " + Primordia.MOD_ID);
    }
}