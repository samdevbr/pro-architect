package com.samdevbr.proarchitect.graphics;

import oshi.util.tuples.Quartet;

public class Color {
    public static final Quartet<Float, Float, Float, Float> BLACK;
    public static final Quartet<Float, Float, Float, Float> WHITE;

    private static float interpolate(int value) {
        return (1f * value) / 255;
    }

    public static Quartet<Float, Float, Float, Float> of(int r, int g, int b, int a) {
        return new Quartet<>(
                interpolate(r),
                interpolate(g),
                interpolate(b),
                interpolate(a)
        );
    }

    public static Quartet<Float, Float, Float, Float> of(long color) {
        int r = (int) ((color >> 24) & 0xff);
        int g = (int) ((color >> 16) & 0xff);
        int b = (int) ((color >> 8) & 0xff);
        int a = (int) ((color) & 0xff);

        return Color.of(r, g, b, a);
    }

    static {
        BLACK = Color.of(0x000000FF);
        WHITE = Color.of(0xFFFFFFFF);
    }
}
