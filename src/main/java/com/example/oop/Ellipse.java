package com.example.oop;

public class Ellipse extends Shape {
    private double majorAxis;
    private double minorAxis;

    public Ellipse() {
    }

    public Ellipse(double majorAxis, double minorAxis) {
        if (majorAxis <= 0 || minorAxis <= 0) {
            throw new IllegalArgumentException("Полуоси эллипса должны быть больше 0");
        }
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    public double getArea() {
        return Math.PI * majorAxis * minorAxis;
    }

    public double getPerimeter() {
        return Math.PI * (3 * (majorAxis + minorAxis) - Math.sqrt((3 * majorAxis + minorAxis) * (majorAxis + 3 * minorAxis)));
    }
}