package nebula.primordia.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class PrimordialLongswordItem extends SwordItem {
    public PrimordialLongswordItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.postHit(stack, target, attacker);
    }
    private void isEnchantable() {
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.primordia.weapon.twohanded"));
            tooltip.add(Text.translatable("tooltip.primordia.stormweaver.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.primordia.weapon.twohanded"));
            tooltip.add(Text.translatable("tooltip.primordia.stormweaver"));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}
