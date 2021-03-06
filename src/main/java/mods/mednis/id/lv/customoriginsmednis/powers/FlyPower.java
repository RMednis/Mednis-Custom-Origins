package mods.mednis.id.lv.customoriginsmednis.powers;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import java.util.function.Predicate;

public class FlyPower extends Power {

    private static Predicate<Entity> shouldStopFlight = null;

    public FlyPower(PowerType<?> type, LivingEntity entity, Boolean fly, Predicate<Entity> shouldStopFlight) {
        super(type, entity);

        if (entity != null && entity.isPlayer()) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.getAbilities().creativeMode){ // Make sure we don't hinder creative mode!
                player.getAbilities().flying = fly;
            }
        }

        //FlyPower.shouldStopFlight = shouldStopFlight;
    }

    public static boolean shouldStopFlight(Entity entity) {
        return shouldStopFlight == null ? entity.isSneaking() : shouldStopFlight.test(entity);

    }
}
