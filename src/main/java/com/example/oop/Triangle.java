package com.example.oop;

public class Triangle extends Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException("Стороны треугольника должны быть больше 0");
        } else if ((sideA >= sideB + sideC) ||
                (sideB >= sideA + sideC) ||
                (sideC >= sideA + sideB)) {
            throw new IllegalArgumentException("Неравенство сторон треугольника.\n" +
                    "Сумма длины двух сторон всегда должны быть больше длины третьей стороны");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getArea() {
        double p = (sideA + sideB + sideC) / 2;
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
}