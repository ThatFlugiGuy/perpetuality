package net.flugi.perpetuality.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponents {

    public static final ConsumableComponent BLINDING_FOOD_CONSUMABLE_COMPONENT = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 24000), 1.0F))
            .build();
    public static final FoodComponent BLINDING_FOOD_COMPONENT = new FoodComponent.Builder()
            .nutrition(8).saturationModifier(0.7F)
            .build();



}
