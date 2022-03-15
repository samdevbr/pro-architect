package com.samdevbr.proarchitect.graphics;

import java.util.List;
import java.util.ArrayList;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.client.render.BufferBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;

public record Grid(Box box) implements IShape {

    public List<Line> createLines() {
        var lines = new ArrayList<Line>();

        for (double y = box.minY + 1; y <= box.maxY + 1; ++y) {
            for (double x = box.minX; x <= box.maxX; ++x) {
                var origin = new Vec3d(x, y, box.minZ);
                var target = new Vec3d(x, y, box.maxZ);

                lines.add(new Line(origin, target));
            }

            for (double z = box.minZ; z <= box.maxZ; ++z) {
                var origin = new Vec3d(box.minX, y, z);
                var target = new Vec3d(box.maxX, y, z);

                lines.add(new Line(origin, target));
            }
        }

        for (double x = box.minX; x <= box.maxX; ++x)
        for (double z = box.minZ; z <= box.maxZ; ++z)
        {
            var origin = new Vec3d(x, box.minY + 1, z);
            var target = new Vec3d(x, box.maxY + 1, z);

            lines.add(new Line(origin, target));
        }

        return lines;
    }

    @Override
    public void render(WorldRenderContext context, BufferBuilder buffer) {
        var lines = createLines();

        lines.forEach(line -> line.render(context, buffer));
    }
}
