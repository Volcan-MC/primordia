package nebula.primordia;

import nebula.primordia.block.ModBlocks;
import nebula.primordia.block.entity.ModBlockEntities;
import nebula.primordia.effect.ModEffects;
import nebula.primordia.item.ModItemGroups;
import nebula.primordia.item.ModItems;
import nebula.primordia.potion.ModPotions;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Primordia implements ModInitializer {
	public static final String MOD_ID = "primordia";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModItemGroups.registerItemGroups();
		ModBlockEntities.registerBlockEntities();

		LOGGER.info("Hello Fabric world!");
	}
}