package com.samdevbr.proarchitect.listener;

import com.google.common.eventbus.Subscribe;
import net.minecraft.server.network.ServerPlayerEntity;
import com.samdevbr.proarchitect.event.PlayerJoinedEvent;
import com.samdevbr.proarchitect.registry.NetworkRegistry;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import com.samdevbr.proarchitect.event.PlayerDisconnectedEvent;
import com.samdevbr.proarchitect.networking.packet.NetworkPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class NetworkEventHandler {
    @Subscribe
    public void onPlayerJoin(PlayerJoinedEvent event) {
        NetworkRegistry.registerReceivers();
    }

    @Subscribe
    public void onPlayerDisconnect(PlayerDisconnectedEvent event) {
        NetworkRegistry.unregisterReceivers();
    }

    @Subscribe
    public void sendPacket(NetworkPacket packet) {
        var actualPacket = packet.packet();
        System.out.println("SEND PACKET");

        var packetBuf = actualPacket.getPacket();

        if (!actualPacket.shouldBroadcast()) {
            ServerPlayNetworking.send(actualPacket.getPlayer(), actualPacket.getId(), packetBuf);
            return;
        }

        for (ServerPlayerEntity player : PlayerLookup.all(actualPacket.getWorld().getServer())) {
            ServerPlayNetworking.send(player, actualPacket.getId(), packetBuf);
        }
    }
}
