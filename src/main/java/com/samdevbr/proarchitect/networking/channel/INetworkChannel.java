package com.samdevbr.proarchitect.networking.channel;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.util.Identifier;

public interface INetworkChannel extends ClientPlayNetworking.PlayChannelHandler {
    Identifier getId();
}
