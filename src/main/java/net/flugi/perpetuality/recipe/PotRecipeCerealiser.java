package net.flugi.perpetuality.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;

public class PotRecipeCerealiser implements RecipeSerializer<PotRecipe> {
    public static final MapCodec<PotRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(PotRecipe::getResult),
                    Ingredient.CODEC.listOf(1,6).fieldOf("ingredients").forGetter(PotRecipe::getIngredients)

            ).apply(instance, PotRecipe::new)
    );

    public static final PacketCodec<RegistryByteBuf, PotRecipe> PACKET_CODEC = PacketCodec.tuple(
            ItemStack.PACKET_CODEC,
            PotRecipe::getResult,
            Ingredient.PACKET_CODEC.collect(PacketCodecs.toList()),
            PotRecipe::getIngredients,
            PotRecipe::new
    );

    @Override
    public MapCodec<PotRecipe> codec() {
        return CODEC;
    }

    @Override
    public PacketCodec<RegistryByteBuf, PotRecipe> packetCodec() {
        return PACKET_CODEC;
    }
}
