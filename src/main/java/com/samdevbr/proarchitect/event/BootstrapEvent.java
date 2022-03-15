package com.samdevbr.proarchitect.event;

public class BootstrapEvent {
    public interface Common {}
    public interface Client {}
    public interface Server {}

    public static final Common COMMON = new Common() {};
    public static final Client CLIENT = new Client() {};
    public static final Server SERVER = new Server() {};
}
