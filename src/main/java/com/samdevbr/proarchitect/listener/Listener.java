package com.samdevbr.proarchitect.listener;

public interface Listener<T> {
    void handle(T event);
}
