package net.flugi.perpetuality.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class TrueBlindnessEffect extends StatusEffect {
    protected TrueBlindnessEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xbd93cf);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}