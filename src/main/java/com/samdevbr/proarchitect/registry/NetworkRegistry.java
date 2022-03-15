package com.samdevbr.proarchitect.registry;

import com.samdevbr.proarchitect.networking.channel.INetworkChannel;
import com.samdevbr.proarchitect.networking.channel.SpawnGridChannel;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class NetworkRegistry {
    public static final SpawnGridChannel SPAWN_GRID_CHANNEL = new SpawnGridChannel();

    public static final INetworkChannel[] channels = new INetworkChannel[] {
            SPAWN_GRID_CHANNEL
    };

    public static void registerReceivers() {
        System.out.println("PLAYER JOINED");

        for (var channel : channels) {
            ClientPlayNetworking.registerReceiver(channel.getId(), channel);
        }
    }

    public static void unregisterReceivers() {
        for (var channel : channels) {
            ClientPlayNetworking.unregisterReceiver(channel.getId());
        }
    }

}
