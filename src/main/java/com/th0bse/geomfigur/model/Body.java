package com.th0bse.geomfigur.model;

public abstract class Body extends GeomFigur {

    public Body(String name) {
        super(name);
    }

    public abstract double getVolume();

    public abstract double getSurfaceArea();
}
