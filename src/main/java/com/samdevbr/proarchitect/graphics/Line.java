package com.samdevbr.proarchitect.graphics;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.util.math.Vec3d;

public record Line(Vec3d origin, Vec3d target) implements IShape {
    @Override
    public void render(WorldRenderContext context, BufferBuilder buffer) {
        var origin = this.origin.subtract(context.camera().getPos());
        var target = this.target.subtract(context.camera().getPos());

        buffer.vertex(origin.x, origin.y, origin.z).color(255, 255, 0, 255).next();
        buffer.vertex(target.x, target.y, target.z).color(255, 255, 0, 255).next();
    }
}
