package nebula.primordia;

import nebula.primordia.block.ModBlocks;
import nebula.primordia.block.entity.ModBlockEntities;
import nebula.primordia.effect.ModEffects;
import nebula.primordia.enchantment.ModEnchantmentEffects;
import nebula.primordia.entity.ModEntities;
import nebula.primordia.entity.custom.SurgeEntity;
import nebula.primordia.item.ModItemComponents;
import nebula.primordia.item.ModItemGroups;
import nebula.primordia.item.ModItems;
import nebula.primordia.potion.ModPotions;
import nebula.primordia.recipe.ModRecipes;
import nebula.primordia.screen.ModScreenHandlers;
import nebula.primordia.util.Cloakable;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
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
		ModScreenHandlers.registerScreenHandlers();
		ModEnchantmentEffects.registerEnchantmentEffects();
		ModRecipes.registerRecipes();
		ModEntities.registerModEntities();
		FabricDefaultAttributeRegistry.register(ModEntities.SURGE, SurgeEntity.createAttributes());
		ModItemComponents.init();
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.STRONG_SLOWNESS, Items.SNOW_BLOCK, ModPotions.HYPOTHERMIA_POTION);

			ServerTickEvents.END_SERVER_TICK.register(server -> {
				for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
					if (player.hasStatusEffect(ModEffects.CLOAKING)) {
						((Cloakable) player).primordia$setCloaked(true);
					} else {
						((Cloakable) player).primordia$setCloaked(false);
					}
				}
			});








		LOGGER.info("Hello Fabric world!");
	});
}
}