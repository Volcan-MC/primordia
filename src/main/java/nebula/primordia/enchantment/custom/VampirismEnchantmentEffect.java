package nebula.primordia.enchantment.custom;

import com.mojang.serialization.MapCodec;
import nebula.primordia.effect.ModEffects;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record VampirismEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<VampirismEnchantmentEffect> CODEC = MapCodec.unit(VampirismEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if(level == 1) {
            ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(ModEffects.FREEZING,300 , 0));
        }

        if(level == 2) {
            ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(ModEffects.FREEZING,300 , 1));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}