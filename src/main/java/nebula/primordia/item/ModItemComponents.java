package nebula.primordia.item;

import com.mojang.serialization.Codec;
import nebula.primordia.Primordia;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModItemComponents {
    public static final ComponentType<Integer> DASH_CAP =
            register("dash_cap", builder -> builder.codec(Codec.INT));


    private static <T>ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Primordia.MOD_ID, id),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void init() {}
}
