import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        System.out.print("Enter side1, side2, side3 of the triangle one at a time: ");
        double side1=input.nextDouble();
        double side2=input.nextDouble();
        double side3=input.nextDouble();
        
        System.out.print("Enter the color of the triangle: ");
        String color=input.next();
        
        System.out.print("Is the triangle filled? (true/false): ");
        boolean filled=input.nextBoolean();
        
        Triangle triangle=new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
        
        System.out.println("Area: "+triangle.getArea());
        System.out.println("Perimeter: "+triangle.getPerimeter());
        System.out.println(triangle.toString());
        System.out.println("Color: "+triangle.getColor());
        System.out.println("Filled: "+triangle.isFilled());
        
        input.close();
    }
}