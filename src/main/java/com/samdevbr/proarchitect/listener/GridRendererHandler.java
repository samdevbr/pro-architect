package com.samdevbr.proarchitect.listener;

import com.samdevbr.proarchitect.bootstrap.Client;
import com.samdevbr.proarchitect.event.CreateGridEvent;
import net.minecraft.util.math.BlockPos;
import com.google.common.eventbus.Subscribe;
import com.samdevbr.proarchitect.graphics.Grid;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;

public class GridRendererHandler {
    private final Map<String, Grid> gridsOnMap = new HashMap<>();

    private String generateId(BlockPos origin) {
        return "GRID--%d-%d-%d".formatted(origin.getX(), origin.getY(), origin.getZ());
    }

    @Subscribe
    public void onCreateGrid(CreateGridEvent event) {
        String id = generateId(event.origin());

        if (gridsOnMap.containsKey(id)) return;

        if (gridsOnMap.values().stream().anyMatch(grid -> grid.box().contains(
                Vec3d.of(event.origin())
        ))) return;

        var grid = new Grid(event.box());
        gridsOnMap.put(id, grid);

        Client.WORLD_RENDER_HANDLER.shapes.put(id, grid);
    }
}
