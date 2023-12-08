package com.th0bse.geomfigur.model;

public class Ball extends Body {

    private double radius;

    public Ball(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
