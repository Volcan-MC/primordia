package nebula.primordia.item.custom;

import com.google.common.base.Suppliers;
import net.minecraft.block.DispenserBlock;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ReverbiumHelmetItem extends Item implements Equipment {

    protected final RegistryEntry<ArmorMaterial> material;
    private final Supplier<AttributeModifiersComponent> attributeModifiers;

    public ReverbiumHelmetItem(RegistryEntry<ArmorMaterial> material, Item.Settings settings) {
        super(settings);
        this.material = material;
        this.attributeModifiers = Suppliers.memoize(() -> {
            int i = material.value().getProtection(ArmorItem.Type.HELMET);
            float f = material.value().toughness();
            AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
            AttributeModifierSlot attributeModifierSlot = AttributeModifierSlot.forEquipmentSlot(ArmorItem.Type.HELMET.getEquipmentSlot());
            Identifier identifier = Identifier.ofVanilla("armor." + ArmorItem.Type.HELMET.getName());
            builder.add(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(identifier, i, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot);
            builder.add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(identifier, f, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot);
            float g = material.value().knockbackResistance();
            if (g > 0.0F) {
                builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(identifier, (double)g, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot);
            }
            return builder.build();
        });
    }
    public AttributeModifiersComponent getAttributeModifiers() {
        return this.attributeModifiers.get();
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }
}
