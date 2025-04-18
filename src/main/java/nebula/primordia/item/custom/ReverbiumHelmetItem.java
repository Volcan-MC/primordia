package nebula.primordia.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;

public class ReverbiumHelmetItem extends Item implements Equipment {
    public ReverbiumHelmetItem(Item.Settings settings) {

        super(settings);
    }
    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }
}
