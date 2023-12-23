package com.example.oop;

import com.example.oop.*;

import java.util.ArrayList;
import java.util.List;

public class mainTest {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapeList.add(new Ellipse(Math.random() * 10 + 1, Math.random() * 10 + 1));
            shapeList.add(new Circle(Math.random() * 10 + 1));
            shapeList.add(new Rectangle(Math.random() * 10 + 1, Math.random() * 10 + 1));
            shapeList.add(new Square(Math.random() * 10 + 1));
            shapeList.add(new Triangle(Math.random() + 3, Math.random() + 7, Math.random() + 5));
            shapeList.add(new RegularTriangle(Math.random() * 10 + 1));
        }

        double totalArea = 0;
        double totalPerimeter = 0;

        for (Shape shape : shapeList) {
            totalArea += shape.getArea();
            totalPerimeter += shape.getPerimeter();
        }
        System.out.println("Суммарная площадь всех фигур: " + totalArea);
        System.out.println("Суммарный периметр всех фигур: " + totalPerimeter + "\n");


        List<Rectangle> rectangles = new ArrayList<>();
        List<Triangle> triangles = new ArrayList<>();
        for (Shape shape : shapeList) {
            if (shape instanceof Rectangle) {
                rectangles.add((Rectangle) shape);
            } else if (shape instanceof Triangle) {
                triangles.add((Triangle) shape);
            }
        }

        double totalAreaRectangles = 0;
        double totalPerimeterRectangles = 0;
        for (Rectangle rectangle : rectangles) {
            totalAreaRectangles += rectangle.getArea();
            totalPerimeterRectangles += rectangle.getPerimeter();
        }
        System.out.println("Суммарная площадь Rectangle: " + totalAreaRectangles);
        System.out.println("Суммарный периметр Rectangle: " + totalPerimeterRectangles + "\n");

        double totalAreaTriangles = 0;
        double totalPerimeterTriangles = 0;
        for (Triangle triangle : triangles) {
            totalAreaTriangles += triangle.getArea();
            totalPerimeterTriangles += triangle.getPerimeter();
        }
        System.out.println("Суммарная площадь Triangle: " + totalAreaTriangles);
        System.out.println("Суммарный периметр Triangle: " + totalPerimeterTriangles);
    }
}
