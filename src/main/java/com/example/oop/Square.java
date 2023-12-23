package com.example.oop;

public class Square extends Rectangle {
    private final double side;

    public Square(double side) {
        super(side, side);
        if (side <= 0) {
            throw new IllegalArgumentException("Стороны квадрата должны быть больше 0");
        }
        this.side = side;
    }

    public double getArea() {
        return super.getArea();
    }

    public double getPerimeter() {
        return super.getArea();
    }
}
