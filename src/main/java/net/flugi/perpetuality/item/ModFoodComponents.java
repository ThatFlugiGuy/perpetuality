package net.flugi.perpetuality.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;

public class ModFoodComponents {
    public static final FoodComponent BLINDING_STEW = new FoodComponent.Builder()
            .nutrition(8).saturationModifier(0.7f)
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS,24000),1)
            .usingConvertsTo(Items.BOWL)
            .build();

}
