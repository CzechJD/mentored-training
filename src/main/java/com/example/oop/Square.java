package com.example.oop;

public class Square extends Rectangle {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Стороны квадрата должны быть больше 0");
        }
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 4;
    }
}
