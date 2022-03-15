package com.samdevbr.proarchitect.listener;

import com.google.common.eventbus.Subscribe;
import com.samdevbr.proarchitect.event.BootstrapEvent;

public class BlockRegistryHandler {
    @Subscribe
    public void onInit(BootstrapEvent.Common event) {
        System.out.println("init blocks");
    }
}
