package nebula.primordia.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record ForgeRecipeInput(ItemStack input, ItemStack cast) implements RecipeInput {
    public ForgeRecipeInput(ItemStack input, ItemStack cast) {
        this.input = input;
        this.cast = cast;
    }

    public ItemStack getStackInSlot(int slot) {
        if (slot == 0){
            return this.input;
        }
        else if (slot == 1){
            return this.cast;
        }
        else {
            throw new IllegalArgumentException("No item for index " + slot);
        }
    }

    public int getSize() {
        return 2;
    }
}
