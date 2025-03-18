package nebula.primordia.item.custom;

import nebula.primordia.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PouchItem extends Item {
    public PouchItem(Item.Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.giveItemStack(new ItemStack(ModItems.BROKEN_SWORD));
        user.giveItemStack(new ItemStack(ModItems.TATTERED_AXE));
        user.giveItemStack(new ItemStack(ModItems.TATTERED_PICKAXE));
        user.giveItemStack(new ItemStack(ModItems.SURVIVOR_BOOTS));
        user.giveItemStack(new ItemStack(ModItems.SURVIVOR_CHESTPLATE));
        user.setStackInHand(hand, ItemStack.EMPTY);
        return super.use(world, user, hand);
    } 
}
