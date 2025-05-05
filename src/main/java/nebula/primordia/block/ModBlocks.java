package nebula.primordia.block;

import nebula.primordia.Primordia;
import nebula.primordia.block.custom.ForgeBlock;
import nebula.primordia.block.custom.TableBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block PALE_OAK_LOG = registerBlock("pale_oak_log",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_PALE_OAK_LOG = registerBlock("stripped_pale_oak_log",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PALE_SAPLING = registerBlock("pale_sapling",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().noCollision().breakInstantly()));
    public static final Block PALE_MOSS = registerBlock("pale_moss",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PALE_OAK_PLANKS = registerBlock("pale_oak_planks",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PALE_OAK_WOOD = registerBlock("pale_oak_wood",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block STRIPPED_PALE_OAK_WOOD = registerBlock("stripped_pale_oak_wood",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PALE_PUMPKIN = registerBlock("pale_pumpkin",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block CARVED_PALE_PUMPKIN = registerBlock("carved_pale_pumpkin",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block PALE_LEAVES = registerBlock("pale_leaves",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().nonOpaque()));
    public static final Block PALE_MOSS_CARPET = registerBlock("pale_moss_carpet",
            new CarpetBlock(AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block FORGE = registerBlock("forge",
            new ForgeBlock(AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block FORGE_BRICKS = registerBlock("forge_bricks",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block STONE_TABLE = registerBlock("stone_table",
            new TableBlock(AbstractBlock.Settings.create().strength(3f).requiresTool().nonOpaque()));




    public static final Block WILLOW_LOG = registerBlock("willow_log",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block WILLOW_LEAVES = registerBlock("willow_leaves",
            new LeavesBlock(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.CHERRY_LEAVES).nonOpaque()));
    public static final Block WILLOW_PLANKS = registerBlock("willow_planks",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block WILLOW_WOOD = registerBlock("willow_wood",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_WILLOW_WOOD = registerBlock("stripped_willow_wood",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block STRIPPED_WILLOW_LOG = registerBlock("stripped_willow_log",
            new Block(AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.WOOD)));
    public static final Block WILLOW_STAIRS = registerBlock("willow_stairs",
            new StairsBlock(ModBlocks.WILLOW_PLANKS.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block WILLOW_SLAB = registerBlock("willow_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block WILLOW_DOOR = registerBlock("willow_door",
            new DoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block WILLOW_TRAPDOOR = registerBlock("willow_trapdoor",
            new TrapdoorBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block WILLOW_BUTTON = registerBlock("willow_button",
            new ButtonBlock(BlockSetType.OAK, 20, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block WILLOW_PRESSURE_PLATE = registerBlock("willow_pressure_plate",
            new PressurePlateBlock(BlockSetType.OAK, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block FISH_STICK = registerBlock("fish_stick",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block HEARTHFLAME_ALTAR = registerBlock("hearthflame_altar",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().nonOpaque()));

    public static final Block DEEPSLATE_SKIRT = registerBlock("chiseled_deepslate_dungeon_bricks",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool()));









    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Primordia.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Primordia.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Primordia.LOGGER.info("Registering Mod Blocks for " + Primordia.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.PALE_OAK_LOG);
            entries.add(ModBlocks.STRIPPED_PALE_OAK_LOG);
            entries.add(ModBlocks.PALE_SAPLING);
            entries.add(ModBlocks.PALE_MOSS);
            entries.add(ModBlocks.PALE_MOSS_CARPET);
            entries.add(ModBlocks.PALE_OAK_PLANKS);
            entries.add(ModBlocks.PALE_OAK_WOOD);
            entries.add(ModBlocks.STRIPPED_PALE_OAK_WOOD);
            entries.add(ModBlocks.PALE_PUMPKIN);
            entries.add(ModBlocks.CARVED_PALE_PUMPKIN);
            entries.add(ModBlocks.PALE_LEAVES);
        });
    }
}
