package nebula.primordia.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent STICK_OF_FISH = new FoodComponent.Builder().nutrition(4).saturationModifier(0.15f)
            .snack().build();

    public static final FoodComponent STICK_OF_FISH_COOKED = new FoodComponent.Builder().nutrition(8).saturationModifier(0.15f)
            .snack().build();

}