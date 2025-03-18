package nebula.primordia.item.custom;

import nebula.primordia.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class TalismanItem extends Item {

    public TalismanItem(Item.Settings Settings) {
        super(Settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 500);
        ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(ModEffects.CLOAKING,600 , 1));
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
