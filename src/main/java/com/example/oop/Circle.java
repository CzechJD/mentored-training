package com.example.oop;

public class Circle extends Ellipse {
    private final double radius;

    public Circle(double radius) {
        super(radius, radius);
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть больше 0");
        }
        this.radius = radius;
    }
    public double getPerimeter() {
        return 2 * (Math.PI * radius);
    }
}