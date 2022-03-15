package com.samdevbr.proarchitect.listener;

import com.google.common.eventbus.Subscribe;
import com.mojang.blaze3d.systems.RenderSystem;
import com.samdevbr.proarchitect.graphics.IShape;
import net.minecraft.client.render.*;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;

import java.util.Map;
import java.util.HashMap;

public class WorldRenderHandler {
    public final Map<String, IShape> shapes = new HashMap<>();

    @Subscribe
    public void onRender(WorldRenderContext context) {
        RenderSystem.enableDepthTest();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.disableTexture();
        RenderSystem.disableBlend();
        RenderSystem.lineWidth(5f);

        for (var shape : shapes.values()) {
            Tessellator tesselator = Tessellator.getInstance();
            BufferBuilder buffer = tesselator.getBuffer();
            buffer.begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

            shape.render(context, buffer);

            tesselator.draw();
        }
    }
}
