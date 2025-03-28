package net.pinne.snowball.mixins;

import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Snowball.class)
public class SnowballMixin {
    @Inject(method = "onHitEntity", at = @At("HEAD"))
    private void addDamageOnHit(EntityHitResult hitResult, CallbackInfo ci) {
        if (hitResult.getEntity() instanceof LivingEntity livingEntity) {
            livingEntity.hurt(livingEntity.damageSources().magic(), 5.0F);
        }
    }
}