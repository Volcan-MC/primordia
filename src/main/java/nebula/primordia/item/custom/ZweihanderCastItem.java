package nebula.primordia.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class ZweihanderCastItem extends Item {

    public ZweihanderCastItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.primordia.swordcast.zweihander.shift.down"));
        } else {
            tooltip.add(Text.translatable("tooltip.primordia.swordcast.zweihander.shift"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
