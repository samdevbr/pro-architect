package com.samdevbr.proarchitect.listener;

import com.google.common.eventbus.Subscribe;
import com.samdevbr.proarchitect.event.BootstrapEvent;
import com.samdevbr.proarchitect.registry.ItemRegistry;

public class ItemRegistryHandler {
    @Subscribe
    public void onInit(BootstrapEvent.Common event) {
        System.out.println("init items");

        ItemRegistry.boot();
    }
}
