package com.samdevbr.proarchitect.bootstrap;

import net.fabricmc.api.ModInitializer;
import com.google.common.eventbus.EventBus;
import com.samdevbr.proarchitect.event.Event;
import com.samdevbr.proarchitect.event.BootstrapEvent;
import com.samdevbr.proarchitect.listener.NetworkEventHandler;
import com.samdevbr.proarchitect.listener.ItemRegistryHandler;
import com.samdevbr.proarchitect.listener.BlockRegistryHandler;

public class Common implements ModInitializer {
    public static final EventBus EVENT_BUS = new EventBus();

    public static final ItemRegistryHandler ITEM_REGISTRY_HANDLER = new ItemRegistryHandler();
    public static final BlockRegistryHandler BLOCK_REGISTRY_HANDLER = new BlockRegistryHandler();
    public static final NetworkEventHandler NETWORK_EVENTS_HANDLER = new NetworkEventHandler();

    private void registerHandlers() {
        EVENT_BUS.register(ITEM_REGISTRY_HANDLER);
        EVENT_BUS.register(BLOCK_REGISTRY_HANDLER);
        EVENT_BUS.register(NETWORK_EVENTS_HANDLER);
    }

    @Override
    public void onInitialize() {
        registerHandlers();

        Event.dispatch(BootstrapEvent.COMMON);
    }
}
