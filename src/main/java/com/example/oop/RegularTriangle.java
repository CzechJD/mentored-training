package com.example.oop;

public class RegularTriangle extends Triangle {
    private final double side;

    public RegularTriangle(double side) {
        super(side, side, side);
        if (side <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть больше 0");
        }
        this.side = side;
    }

    public double getArea() {
        return super.getArea();
    }

    public double getPerimeter() {
        return super.getPerimeter();
    }
}
