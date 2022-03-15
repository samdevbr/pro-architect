package com.samdevbr.proarchitect.bootstrap;

import com.samdevbr.proarchitect.event.Event;
import com.samdevbr.proarchitect.event.BootstrapEvent;
import net.fabricmc.api.DedicatedServerModInitializer;

public class Server implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        Event.dispatch(BootstrapEvent.SERVER);

        System.out.println("init on server");
    }
}
