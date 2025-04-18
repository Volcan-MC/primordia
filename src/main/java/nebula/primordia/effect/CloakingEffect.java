package nebula.primordia.effect;

import nebula.primordia.util.Cloakable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class CloakingEffect extends StatusEffect {
    public CloakingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
                if(entity.isMobOrPlayer()) {
                    entity.setInvisible(true);
                    entity.setSilent(true);
                    entity.setStuckArrowCount(0);
                    return true;
                }


        return super.applyUpdateEffect(entity, amplifier);
    }


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}