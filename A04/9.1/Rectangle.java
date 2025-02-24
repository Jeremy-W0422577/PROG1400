public class Rectangle {
    //Data
    private double width;
    private double height;

    //No-arg constructor that creates a rectangle
    public Rectangle() {
        this.width=1;
        this.height=1;
    }

    //Constructor that creates a rectangle with specified width and height
    public Rectangle(double width, double height) {
        this.width=width;
        this.height=height;
    }

    //Method to calculate area
    public double getArea() {
        return width*height;
    }

    //Method to calculate perimeter
    public double getPerimeter() {
        return 2*(width+height);
    }

    //Getters for width and height
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public static void main(String[] args) {
        //Create two Rectangles
        Rectangle rectangle1=new Rectangle(4, 40);
        Rectangle rectangle2=new Rectangle(3.5, 35.9);

        //Display properties of the first rectangle
        System.out.println("Rectangle 1:");
        System.out.println("Width: "+rectangle1.getWidth());
        System.out.println("Height: "+rectangle1.getHeight());
        System.out.println("Area: "+rectangle1.getArea());
        System.out.println("Perimeter: "+rectangle1.getPerimeter());

        //Display properties of the second rectangle
        System.out.println("\nRectangle 2:");
        System.out.println("Width: "+rectangle2.getWidth());
        System.out.println("Height: "+rectangle2.getHeight());
        System.out.println("Area: "+rectangle2.getArea());
        System.out.println("Perimeter: "+rectangle2.getPerimeter());
    }
}