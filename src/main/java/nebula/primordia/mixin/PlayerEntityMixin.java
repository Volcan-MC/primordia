package nebula.primordia.mixin;

import nebula.primordia.util.Cloakable;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin implements Cloakable {
    @Unique
    private static final TrackedData<Boolean> CLOAKED = DataTracker.registerData(PlayerEntity.class, TrackedDataHandlerRegistry.BOOLEAN);



    @Inject(method = "initDataTracker", at = @At("TAIL"))
    private void initCloakTracker(DataTracker.Builder builder,CallbackInfo ci) {
        builder.add(CLOAKED,false);

    }

    @Override
    public void primordia$setCloaked(boolean cloaked) {
        ((PlayerEntity)(Object)this).getDataTracker().set(CLOAKED, cloaked);
    }

    @Override
    public boolean primordia$isCloaked() {
        return ((PlayerEntity)(Object)this).getDataTracker().get(CLOAKED);
    }


}