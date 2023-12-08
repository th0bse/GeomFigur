package com.th0bse.geomfigur.model;

public class Square extends Shape {

        private double sideLength;

        public Square(String name, double sideLength) {
            super(name);
            this.sideLength = sideLength;
        }

        @Override
        public double getArea() {
            return Math.pow(sideLength, 2);
        }
}
