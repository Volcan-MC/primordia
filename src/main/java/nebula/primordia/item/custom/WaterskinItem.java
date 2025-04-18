package nebula.primordia.item.custom;

import nebula.primordia.effect.ModEffects;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class WaterskinItem extends Item {
    public WaterskinItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 500);
        ((LivingEntity) user).addStatusEffect(new StatusEffectInstance(ModEffects.BLEEDING,300 , 1));
        return TypedActionResult.success(itemStack, world.isClient());
    }

    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.primordia.contents"));
        } else {
            tooltip.add(Text.translatable("tooltip.primordia.waterskin"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
