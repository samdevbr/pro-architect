package com.samdevbr.proarchitect.event;

import net.minecraft.util.math.BlockPos;
import com.samdevbr.proarchitect.graphics.Size;
import net.minecraft.util.math.Box;

public record CreateGridEvent(Size size, BlockPos origin) {
    public Box box() {
        var topmostCorner = origin.add(size.width(), size.height(), size.depth());

        return new Box(origin, topmostCorner);
    }
}
