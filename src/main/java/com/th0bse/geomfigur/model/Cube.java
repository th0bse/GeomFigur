package com.th0bse.geomfigur.model;

public class Cube extends Body {

    private double width;

    public Cube(String name, double width) {
        super(name);
        this.width = width;
    }

    @Override
    public double getVolume() {
        return width * width * width;
    }

    @Override
    public double getSurfaceArea() {
        return 6 * width * width;
    }
}
