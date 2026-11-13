package net.flugi.perpetuality.item;


import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.ClearAllEffectsConsumeEffect;
import net.minecraft.item.consume.TeleportRandomlyConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;

public class ModFoodComponents {

    public static final FoodComponent BEETROOT_SOUP = new FoodComponent.Builder()
            .nutrition(4).saturationModifier(0.4F).build();
    public static final FoodComponent MUSHROOM_STEW = new FoodComponent.Builder()
            .nutrition(4).saturationModifier(0.4F).build();

    public static final FoodComponent PERPETUAL_STEW = new FoodComponent.Builder()
            .nutrition(3).saturationModifier(0.4F).build();
    public static final FoodComponent MEAT_STEW = new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.7F).build();
    public static final FoodComponent VEGETABLE_STEW = new FoodComponent.Builder()
            .nutrition(5).saturationModifier(0.4F).build();
    public static final FoodComponent KELP_STEW = new FoodComponent.Builder()
            .nutrition(5).saturationModifier(0.6F).build();
    public static final FoodComponent DIRT_STEW = new FoodComponent.Builder()
            .nutrition(1).saturationModifier(0.1F).build();
    public static final FoodComponent BORSCHT = new FoodComponent.Builder()
            .nutrition(10).saturationModifier(0.7F).build();
    public static final FoodComponent PORRIDGE = new FoodComponent.Builder()
            .nutrition(7).saturationModifier(0.2F).build();
    public static final FoodComponent FRUIT_PORRIDGE = new FoodComponent.Builder()
            .nutrition(7).saturationModifier(0.6F).build();
    public static final FoodComponent MASHED_POTATOES = new FoodComponent.Builder()
            .nutrition(7).saturationModifier(0.4F).build();
    public static final FoodComponent COCOA_CEREAL = new FoodComponent.Builder()
            .nutrition(3).saturationModifier(0.4F).build();
    public static final FoodComponent BREAD_SOUP = new FoodComponent.Builder()
            .nutrition(2).saturationModifier(0.5F).build();
    public static final FoodComponent APPLE_COMPOTE = new FoodComponent.Builder()
            .nutrition(6).saturationModifier(0.5F).build();
    public static final FoodComponent CHORUS_COMPOTE = new FoodComponent.Builder()
            .nutrition(3).saturationModifier(0.5F).build();
    public static final FoodComponent GLOW_BERRY_COMPOTE = new FoodComponent.Builder()
            .nutrition(4).saturationModifier(0.5F).build();
    public static final FoodComponent SWEET_BERRY_COMPOTE = new FoodComponent.Builder()
            .nutrition(4).saturationModifier(0.5F).build();
    public static final FoodComponent FRUIT_COMPOTE = new FoodComponent.Builder()
            .nutrition(3).saturationModifier(0.5F).build();


    public static final ConsumableComponent FOOD = food().build();
    public static final ConsumableComponent DRINK = drink().build();

    public static final ConsumableComponent COCOA = food().consumeEffect(ClearAllEffectsConsumeEffect.INSTANCE).build();
    public static final ConsumableComponent SPEED = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SPEED, 100, 0), 1F))
            .build();
    public static final ConsumableComponent REGEN = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 60, 0), 1F))
            .build();
    public static final ConsumableComponent GLOW = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0), 1F))
            .build();

    public static final ConsumableComponent CHORUS = drink().consumeEffect(new TeleportRandomlyConsumeEffect()).build();
    public static final ConsumableComponent GIVES_HUNGER = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER, 100, 1), 1F))
            .build();

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }

    public static ConsumableComponent.Builder drink() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.DRINK).sound(SoundEvents.ENTITY_GENERIC_DRINK).consumeParticles(false);
    }

}
