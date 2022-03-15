package com.samdevbr.proarchitect.networking.channel;

import net.minecraft.util.Identifier;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.client.MinecraftClient;
import com.samdevbr.proarchitect.event.Event;
import com.samdevbr.proarchitect.ProArchitect;
import com.samdevbr.proarchitect.graphics.Size;
import com.samdevbr.proarchitect.event.CreateGridEvent;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.network.ClientPlayNetworkHandler;

public class SpawnGridChannel implements INetworkChannel {
    @Override
    public void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        var size = new Size(buf.readInt(), buf.readInt(), buf.readInt());
        var position = buf.readBlockPos();

        var event = new CreateGridEvent(size, position);

        Event.dispatch(event);
    }

    @Override
    public Identifier getId() {
        return new Identifier(ProArchitect.ID, "spawn_grid");
    }
}
