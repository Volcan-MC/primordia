package nebula.primordia.item.custom;

import nebula.primordia.enchantment.ModEnchantments;
import nebula.primordia.item.ModItemComponents;
import nebula.primordia.item.ModItems;
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
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class ReverbiumGauntletItem extends ShovelItem {
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
    private int getDashCap(ItemStack stack) {
        if (stack.get(ModItemComponents.DASH_CAP) != null) {
            return stack.get(ModItemComponents.DASH_CAP);
        } else {
            return 3;
        }

    }
    private void setDashCap(ItemStack stack, int value) {
        stack.set(ModItemComponents.DASH_CAP,value);
    }

    private void applyDashMovement(LivingEntity user,ItemStack stack) {

        float yaw = user.getYaw();
        float pitch = user.getPitch();
        Vec3d direction = Vec3d.fromPolar(pitch, yaw).normalize().multiply(3.0);
        user.addVelocity(direction.x, direction.y / 2, direction.z);
        if (user.isOnGround()) {
            user.move(MovementType.SELF, new Vec3d(0.0, 1.2, 0.0));
        }
        if (getDashCap(stack) >= 2) {
            setDashCap(stack,0);
            ((PlayerEntity)user).getItemCooldownManager().set(this,250);
        } else  {
            setDashCap(stack,getDashCap(stack) + 1);
        }
    }
    public static boolean hasEnchantment(ItemStack stack, RegistryKey<Enchantment> enchantment) {
        return stack.getEnchantments().getEnchantments().toString().
                contains(enchantment.getValue().toString());
    }
    public void sonicDashTrail(ItemStack stack, PlayerEntity user, double radius) {
        World world = user.getWorld();

        if (world instanceof ServerWorld serverWorld && hasEnchantment(stack, ModEnchantments.PROPULSION ) && !user.getItemCooldownManager().isCoolingDown(this)) {
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
            if (getDashCap(stack) >= 2) {
                setDashCap(stack,0);
                user.getItemCooldownManager().set(this,250);
            } else  {
                setDashCap(stack,getDashCap(stack) + 1);
            }
        }

    }

    @Override
    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 78000;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (hasEnchantment(stack, ModEnchantments.PROPULSION) || hasEnchantment(stack,ModEnchantments.MAGNETISM)&& !user.getItemCooldownManager().isCoolingDown(this)) {
            user.setCurrentHand(hand);
            return TypedActionResult.consume(stack);
        } else {
            if (user.getOffHandStack().isOf(ModItems.REVERBIUM_GAUNTLET)) {
                user.swingHand(Hand.OFF_HAND);
            }
            return TypedActionResult.pass(stack);
        }
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (hasEnchantment(stack, ModEnchantments.PROPULSION)) {
            if (user.isSneaking()) {
                sonicDashTrail(stack, (PlayerEntity) user, 20);
            } else {
                applyDashMovement(user,stack);
                ((PlayerEntity)user).useRiptide(20,4,stack);
            }
        }
        else if (hasEnchantment(stack,ModEnchantments.MAGNETISM)){

        }
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }


    @Override
    public UseAction getUseAction(ItemStack stack) {
        if (hasEnchantment(stack,ModEnchantments.PROPULSION) || hasEnchantment(stack,ModEnchantments.MAGNETISM)) {
            return UseAction.BOW;
        } else {
            return UseAction.NONE;
        }
    }


    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (hasEnchantment(stack,ModEnchantments.MAGNETISM) && user instanceof PlayerEntity player && !player.getItemCooldownManager().isCoolingDown(this)) {




            if (world instanceof ServerWorld serverWorld) {
                Vec3d playerPos = user.getPos();
                serverWorld.spawnParticles(ParticleTypes.PORTAL,user.getX(),user.getY(),user.getZ(),10,2.5,2.5,2.5,0.5);

                Box baseBox = user.getBoundingBox().expand(8);

                List<LivingEntity> entities = serverWorld.getEntitiesByClass(LivingEntity.class,
                        baseBox,
                        entity -> entity != user);

                for (Entity entity : entities) {
                    if (entity instanceof LivingEntity livingEntity) {
                        Vec3d wawadirection = user.getPos().subtract(livingEntity.getPos()).normalize();
                        double p = 0.2;

                        Vec3d velocity = wawadirection.multiply(p);
                        livingEntity.setVelocity(0, 0, 0);
                        livingEntity.addVelocity(velocity.x, velocity.y, velocity.z);
                        livingEntity.velocityModified = true;

                        livingEntity.damage(user.getDamageSources().playerAttack((PlayerEntity) user), 0.005F);
                    }
                }
            }

        }

        super.usageTick(world, user, stack, remainingUseTicks);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user.getOffHandStack().isOf(ModItems.REVERBIUM_GAUNTLET) && !hasEnchantment(user.getOffHandStack(),ModEnchantments.PROPULSION)&& !hasEnchantment(user.getOffHandStack(),ModEnchantments.MAGNETISM)) {
            World world = user.getWorld();
            user.attack(entity);
            user.spawnSweepAttackParticles();
            user.swingHand(Hand.OFF_HAND);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, SoundCategory.NEUTRAL, 1F, 1F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
            );
        }
        return super.useOnEntity(stack, user, entity, hand);
    }
}