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
import nebula.primordia.recipe.ForgeRecipe;
import nebula.primordia.screen.ModScreenHandlers;
import nebula.primordia.util.Cloakable;
import nebula.primordia.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Primordia implements ModInitializer {
	public static final String MOD_ID = "primordia";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//register recipe type
		Registry.register(Registries.RECIPE_SERIALIZER, ForgeRecipe.Serializer.ID, ForgeRecipe.Serializer.INSTANCE);
		Registry.register(Registries.RECIPE_TYPE, ForgeRecipe.Type.ID, ForgeRecipe.Type.INSTANCE);

		//register content
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModItemGroups.registerItemGroups();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModEnchantmentEffects.registerEnchantmentEffects();
		ModEntities.registerModEntities();

		ModLootTableModifiers.modifyLootTables();
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

			TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 1, factories -> {
				factories.add((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 3),
						new ItemStack(ModItems.SWORD_CAST_NORMAL, 1), 7, 2, 0.04f));
			});

			TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3, factories -> {
				factories.add((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 9),
						new ItemStack(ModItems.SWORD_CAST_LONGSWORD, 2), 7, 2, 0.04f));
			});

		LOGGER.info("Hello Fabric world!");
	});
}
}