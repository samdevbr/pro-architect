package com.samdevbr.proarchitect.networking.packet;

import net.minecraft.util.Identifier;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.network.ServerPlayerEntity;

public interface INetworkPacket {
    Identifier getId();
    PacketByteBuf getPacket();
    ServerPlayerEntity getPlayer();
    ServerWorld getWorld();

    default boolean shouldBroadcast() {
        return false;
    }
}
