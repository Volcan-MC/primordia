package nebula.primordia.screen;

import nebula.primordia.Primordia;
import nebula.primordia.screen.custom.ForgeScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {

    public static final ScreenHandlerType<ForgeScreenHandler> FORGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Primordia.MOD_ID, "forge_screen_handler"),
                    new ExtendedScreenHandlerType<>(ForgeScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        Primordia.LOGGER.info("Registering Screen Handlers for " + Primordia.MOD_ID);
    }
}