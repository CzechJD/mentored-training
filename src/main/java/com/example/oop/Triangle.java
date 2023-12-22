package com.example.oop;

public class Triangle extends Shape {
    private double length1;
    private double length2;
    private double length3;

    public Triangle() {
    }

    public Triangle(double length1, double length2, double length3) {
        if (length1 <= 0 || length2 <= 0 || length3 <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть больше 0");
        }
        this.length1 = length1;
        this.length2 = length2;
        this.length3 = length3;
    }

    public double getArea() {
        double p = (length1 + length2 + length3) / 2;
        return Math.sqrt(p * (p - length1) * (p - length2) * (p - length3));
    }

    public double getPerimeter() {
        return length1 + length2 + length3;
    }
}