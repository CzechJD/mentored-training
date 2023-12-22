package com.example.oop;

public class RegularTriangle extends Triangle {
    private double side;

    public RegularTriangle(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть больше 0");
        }
        this.side = side;
    }

    public double getArea() {
        return (Math.sqrt(3) / 4) * Math.pow(side, 2);
    }

    public double getPerimeter() {
        return 3 * side;
    }
}
