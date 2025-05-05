package nebula.primordia.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class StormweaverItem extends SwordItem {
    public StormweaverItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.primordia.weapon.twohanded"));
            tooltip.add(Text.translatable("tooltip.primordia.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.primordia.weapon.twohanded"));
            tooltip.add(Text.translatable("tooltip.primordia.stormweaver"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
