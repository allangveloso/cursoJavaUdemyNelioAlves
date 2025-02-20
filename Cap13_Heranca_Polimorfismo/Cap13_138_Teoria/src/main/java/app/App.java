package app;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import enums.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);

        System.out.println( "Enter the number of shapes: " );
        int nbrOfShapes = sc.nextInt();

        List<Shape> shapes = new ArrayList<>();

        for (int x = 1; x <= nbrOfShapes; x++) {
            System.out.println("Shape #" + x + " data:");
            System.out.println("Rectangle or Circle (r/c) ?");
            char shapeForm = Character.toLowerCase(sc.next().charAt(0));

            System.out.println("Color " + new ArrayList<Color>(Arrays.asList(Color.values())));
            Color color = Color.valueOf(sc.next().toUpperCase());

            if (shapeForm == 'r') {
                System.out.println("Width: ");
                Double width = sc.nextDouble();
                System.out.println("Height: ");
                Double height = sc.nextDouble();

                shapes.add(new Rectangle(color, width, height));
            } else if (shapeForm == 'c') {
                System.out.println("Radius: ");
                Double radius = sc.nextDouble();

                shapes.add(new Circle(color, radius));
            }
        }
        System.out.println("SHAPES AREA:");
        for (Shape shape : shapes) {
            System.out.print(shape+" (");
            System.out.print(shape.getColor());
            System.out.print("): ");
            System.out.println(String.format("%.2f", shape.area()));
            }

        sc.close();
    }

}
