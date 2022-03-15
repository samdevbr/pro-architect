package com.samdevbr.proarchitect.graphics;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.minecraft.client.render.BufferBuilder;

public interface IShape {
    void render(WorldRenderContext context, BufferBuilder buffer);
}
