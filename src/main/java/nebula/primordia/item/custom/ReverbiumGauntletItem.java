package nebula.primordia.item.custom;

import nebula.primordia.enchantment.ModEnchantments;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ReverbiumGauntletItem extends SwordItem {

    public ReverbiumGauntletItem(ToolMaterial toolMaterial, Settings settings) {

        super(toolMaterial, settings);
    }
    public static AttributeModifiersComponent createAttributeModifiers(ToolMaterial material, int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                BASE_ATTACK_DAMAGE_MODIFIER_ID, (double)((float)baseAttackDamage + material.getAttackDamage()), EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, (double)attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }


    private void applyDashMovement(LivingEntity user) {
        float yaw = user.getYaw();
        float pitch = user.getPitch();
        Vec3d direction = Vec3d.fromPolar(pitch, yaw).normalize().multiply(3.0);
        user.addVelocity(direction.x, 0.05, direction.z);
        if (user.isOnGround()) {
            user.move(MovementType.SELF, new Vec3d(0.0, 1.2, 0.0));
        }
    }
    public static boolean hasEnchantment(ItemStack stack, RegistryKey<Enchantment> enchantment) {
        return stack.getEnchantments().getEnchantments().toString().
                contains(enchantment.getValue().toString());
    }
    public static void SonicDashTrail(ItemStack stack, PlayerEntity user, double radius) {
        World world = user.getWorld();
        if (world instanceof ServerWorld serverWorld && !hasEnchantment(stack, ModEnchantments.PROPULSION) ) {
            float pitch = user.getPitch();
            float yaw = user.getYaw();
            Vec3d playerPos = user.getPos();
            double x = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
            double y = -Math.sin(Math.toRadians(pitch));
            double z = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));

            Vec3d direction = new Vec3d(x, y, z).normalize();

            for (int i = 1; i <= radius ; i++) {
                Vec3d particlePos = playerPos.add(direction.multiply(i));
                serverWorld.spawnParticles(ParticleTypes.SONIC_BOOM,
                        particlePos.x, particlePos.y + 1, particlePos.z,
                        1, 0.0, 0.0, 0.0, 0.0);


                double otherradius = 3.0;
                List<LivingEntity> entities = serverWorld.getEntitiesByClass(LivingEntity.class,
                        new Box(particlePos.x - otherradius, particlePos.y - otherradius, particlePos.z - otherradius,
                                particlePos.x + otherradius, particlePos.y + otherradius, particlePos.z + otherradius),
                        entity -> entity != user);

                for (Entity entity : entities) {
                    if (entity instanceof LivingEntity livingEntity) {
                        livingEntity.damage(user.getDamageSources().sonicBoom(user), 8.0F);
                    }
                }

            }

        } else {




        }

    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        entity.damage(entity.getRecentDamageSource().getAttacker().getDamageSources().playerAttack(user),(float)user.getAttributes().getValue(EntityAttributes.GENERIC_ATTACK_DAMAGE));

        user.swingHand(Hand.OFF_HAND);
        return super.use(world, user, hand);
    }


    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = user.getWorld();
        user.attack(entity);
        user.spawnSweepAttackParticles();
        user.swingHand(Hand.OFF_HAND);
        world.playSound(
                null,
                user.getX(),
                user.getY(),
                user.getZ(),
                SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP,
                SoundCategory.NEUTRAL,
                1F,
                1F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );


        return super.useOnEntity(stack, user, entity, hand);
    }
}
