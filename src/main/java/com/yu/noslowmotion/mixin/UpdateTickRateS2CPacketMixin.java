package com.yu.noslowmotion.mixin;

import net.minecraft.network.packet.s2c.play.UpdateTickRateS2CPacket;
import net.minecraft.world.tick.TickManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(UpdateTickRateS2CPacket.class)
public class UpdateTickRateS2CPacketMixin {
    /**
     * @author yu
     * @reason fuck you mojang i want carpet /tick back
     */
    @Overwrite
    public static UpdateTickRateS2CPacket create(TickManager tickManager) {
        float tickrate = tickManager.getTickRate();
        if (tickrate <= 20) {
            tickrate=20;
        }
        return new UpdateTickRateS2CPacket(tickrate, tickManager.isFrozen());
    }
}
