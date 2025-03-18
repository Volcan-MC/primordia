package nebula.primordia.item.custom;

import java.util.List;
import net.minecraft.block.DispenserBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.text.Text;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BrokenSwordItem extends Item implements Equipment {
    public static final int field_30918 = 5;
    public static final float MIN_DAMAGE_AMOUNT_TO_BREAK = 3.0F;

    public BrokenSwordItem(Item.Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this, ArmorItem.DISPENSER_BEHAVIOR);
    }

    public String getTranslationKey(ItemStack stack) {
        DyeColor dyeColor = (DyeColor)stack.get(DataComponentTypes.BASE_COLOR);
        if (dyeColor != null) {
            String var10000 = this.getTranslationKey();
            return var10000 + "." + dyeColor.getName();
        } else {
            return super.getTranslationKey(stack);
        }
    }

    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        BannerItem.appendBannerTooltip(stack, tooltip);
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 72000;
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        return TypedActionResult.consume(itemStack);
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isIn(ItemTags.PLANKS) || super.canRepair(stack, ingredient);
    }

    public EquipmentSlot getSlotType() {
        return EquipmentSlot.OFFHAND;
    }
}
