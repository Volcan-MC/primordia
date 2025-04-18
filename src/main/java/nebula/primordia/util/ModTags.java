package nebula.primordia.util;

import nebula.primordia.Primordia;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TATTERED_TOOLS = createTag("needs_tattered_tools");
        public static final TagKey<Block> INCORRECT_FOR_TATTERED_TOOLS = createTag("incorrect_for_tattered_tools");
        public static final TagKey<Block> INCORRECT_FOR_STORM_TOOLS = createTag("incorrect_for_storm_tools");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Primordia.MOD_ID, name));
        }
    }
}