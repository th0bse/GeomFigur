package com.th0bse.geomfigur.model;

public abstract class GeomFigur {

    protected String name;

    public GeomFigur(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
