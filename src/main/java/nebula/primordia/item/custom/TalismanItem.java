package nebula.primordia.item.custom;

import nebula.primordia.effect.ModEffects;
import nebula.primordia.util.Cloakable;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TalismanItem extends Item {

    public TalismanItem(Settings Settings) {
        super(Settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 500);
        user.addStatusEffect(new StatusEffectInstance(ModEffects.CLOAKING,300 , 1));
        if (world instanceof ServerWorld serverWorld) {

            ((Cloakable) user).primordia$setCloaked(true);

        }


        return TypedActionResult.success(itemStack, world.isClient());
    }
}