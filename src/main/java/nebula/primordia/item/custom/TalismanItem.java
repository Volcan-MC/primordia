package nebula.primordia.item.custom;

import nebula.primordia.Primordia;
import nebula.primordia.effect.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class TalismanItem extends Item {

    public TalismanItem(Settings Settings) {
        super(Settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 500);
        user.addStatusEffect(new StatusEffectInstance(ModEffects.CLOAKING,300 , 1));
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
