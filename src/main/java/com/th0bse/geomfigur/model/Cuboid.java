package com.th0bse.geomfigur.model;

public class Cuboid extends Body {

    private double width;
    private double height;
    private double depth;

    public Cuboid(String name, double width, double height, double depth) {
        super(name);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return width * height * depth;
    }

    @Override
    public double getSurfaceArea() {
        return 2 * (width * height + width * depth + height * depth);
    }
}
