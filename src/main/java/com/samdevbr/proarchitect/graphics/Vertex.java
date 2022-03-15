package com.samdevbr.proarchitect.graphics;

import oshi.util.tuples.Quartet;

public class Vertex {
    public final Line line;
    public final Quartet<Float, Float, Float, Float> color;

    public Vertex(Line line, Quartet<Float, Float, Float, Float> color) {
        this.line = line;
        this.color = color;
    }
}
