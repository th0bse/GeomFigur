package com.th0bse.geomfigur.model;

public abstract class Shape extends GeomFigur {

    public Shape(String name) {
        super(name);
    }

    public abstract double getArea();
}
