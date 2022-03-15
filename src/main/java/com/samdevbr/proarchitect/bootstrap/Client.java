package com.samdevbr.proarchitect.bootstrap;

import com.samdevbr.proarchitect.event.Event;
import net.fabricmc.api.ClientModInitializer;
import com.samdevbr.proarchitect.event.BootstrapEvent;
import com.samdevbr.proarchitect.event.PlayerJoinedEvent;
import com.samdevbr.proarchitect.listener.WorldRenderHandler;
import com.samdevbr.proarchitect.listener.GridRendererHandler;
import com.samdevbr.proarchitect.event.PlayerDisconnectedEvent;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class Client implements ClientModInitializer {
    public static final WorldRenderHandler WORLD_RENDER_HANDLER = new WorldRenderHandler();
    public static final GridRendererHandler GRID_RENDERER_HANDLER = new GridRendererHandler();

    private void registerHandlers() {
        Common.EVENT_BUS.register(WORLD_RENDER_HANDLER);
        Common.EVENT_BUS.register(GRID_RENDERER_HANDLER);
    }

    @Override
    public void onInitializeClient() {
        registerHandlers();

        Event.dispatch(BootstrapEvent.CLIENT);

        WorldRenderEvents.LAST.register(Event::dispatch);

        ClientPlayConnectionEvents.JOIN.register((networkHandler, packetSender, client) -> Event.dispatch(new PlayerJoinedEvent() { }));
        ClientPlayConnectionEvents.DISCONNECT.register((networkHandler, client) -> Event.dispatch(new PlayerDisconnectedEvent() { }));
    }
}
