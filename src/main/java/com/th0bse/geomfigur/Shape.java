package com.th0bse.geomfigur;

public enum Shape {

    CIRCLE("Circle"),
    RECTANGLE("Rectangle"),
    SQUARE("Square"),
    BALL("Ball"),
    CUBOID("Cuboid"),
    CUBE("Cube");

    private final String name;

    Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Shape fromString(String name) {
        for (Shape shape : Shape.values()) {
            if (shape.name.equalsIgnoreCase(name)) {
                return shape;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
