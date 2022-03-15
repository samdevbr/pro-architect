package com.samdevbr.proarchitect.event;

import com.samdevbr.proarchitect.bootstrap.Common;

public final class Event {
    public static void dispatch(Object event) {
        Common.EVENT_BUS.post(event);
    }
}
