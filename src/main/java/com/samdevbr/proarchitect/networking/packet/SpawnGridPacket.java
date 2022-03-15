package com.samdevbr.proarchitect.networking.packet;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketByteBuf;
import com.samdevbr.proarchitect.ProArchitect;
import net.minecraft.server.world.ServerWorld;
import com.samdevbr.proarchitect.graphics.Size;
import net.minecraft.server.network.ServerPlayerEntity;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;

public record SpawnGridPacket(ServerWorld world, Size size, BlockPos position) implements INetworkPacket {
    @Override
    public Identifier getId() {
        return new Identifier(ProArchitect.ID, "spawn_grid");
    }

    @Override
    public PacketByteBuf getPacket() {
        var packet = PacketByteBufs.create();

        packet.writeInt(size.width());
        packet.writeInt(size.height());
        packet.writeInt(size.depth());

        packet.writeBlockPos(position);

        return packet;
    }

    @Override
    public ServerPlayerEntity getPlayer() {
        return null;
    }

    @Override
    public ServerWorld getWorld() {
        return world();
    }

    @Override
    public boolean shouldBroadcast() {
        return true;
    }

    public static NetworkPacket build(ServerWorld world, Size size, BlockPos position) {
        return new NetworkPacket(
                new SpawnGridPacket(world, size, position)
        );
    }
}
