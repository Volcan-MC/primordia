package nebula.primordia.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record ForgeRecipe(Ingredient input, Ingredient cast, ItemStack output) implements Recipe<ForgeRecipeInput> {
    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.input);
        list.add(this.cast);
        return list;
    }

    @Override
    public boolean matches(ForgeRecipeInput input, World world) {
        return this.input.test(input.getStackInSlot(0)) && this.cast.test(input.getStackInSlot(1));
    }

    @Override
    public ItemStack craft(ForgeRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Serializer implements RecipeSerializer<ForgeRecipe> {
        public static final MapCodec<ForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("input").forGetter(ForgeRecipe::input),
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("cast").forGetter(ForgeRecipe::cast),
                ItemStack.CODEC.fieldOf("result").forGetter(ForgeRecipe::output)
        ).apply(inst, ForgeRecipe::new));

        public static final Serializer INSTANCE = new Serializer();
        public static final Identifier ID = Identifier.of("primordia:forge");

        public static final PacketCodec<RegistryByteBuf, ForgeRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, ForgeRecipe::input,
                        Ingredient.PACKET_CODEC, ForgeRecipe::cast,
                        ItemStack.PACKET_CODEC, ForgeRecipe::output,
                        ForgeRecipe::new);

        @Override
        public MapCodec<ForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, ForgeRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }

    public static class Type implements RecipeType<ForgeRecipe> {
        // Define ExampleRecipe.Type as a singleton by making its constructor private and exposing an instance.
        private Type() {}
        public static final Type INSTANCE = new Type();

        // This will be needed in step 4
        public static final Identifier ID = Identifier.of("primordia:forge");
    }
}