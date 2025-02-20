package entities;

import enums.Color;

import static java.lang.Math.pow;

public class Circle extends Shape{
    private Double radius;

    public Circle() {
        super();
    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return Math.PI * pow(radius,2);
    }

    @Override
    public String toString() {
        return "Circle";
    }
}
