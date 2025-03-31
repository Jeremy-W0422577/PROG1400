import java.util.Scanner;

class GeoObject {
    private String color;
    private boolean filled;

    public GeoObject() {
        this.color="white";
        this.filled=false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color=color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled=filled;
    }

    public String toString() {
        return "Color: "+color+" and filled: "+filled;
    }
}

class Triangle extends GeoObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        this.side1=1.0;
        this.side2=1.0;
        this.side3=1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getArea() {
        double s=getPerimeter()/2;
        return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
    }

    public double getPerimeter() {
        return side1+side2+side3;
    }

    public String toString() {
        return "Triangle: side1 = "+side1+" side2 = "+side2+" side3 = "+side3;
    }
}

public class Final {
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