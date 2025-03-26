public class MyPoint {
    //Fields to store x and y coordinates of point
    private double x;
    private double y;

    //No-arg initializes the point (0, 0)
    public MyPoint() {
        this(0, 0);
    }

    //Constructor initializes point with specified x and y coordinates
    public MyPoint(double x, double y) {
        this.x=x;
        this.y=y;
    }

    //Getter method returns x-coordinate of point
    public double getX() {
        return x;
    }

    //Getter method returns y-coordinate of point
    public double getY() {
        return y;
    }

    //Instance method calculates distance from one point to another MyPoint object
    public double distance(MyPoint other) {
        //Utilizing static distance method for calculation
        return distance(this, other);
    }

    //Instance method calculates distance from point to specified coordinates (x, y)
    public double distance(double x, double y) {
        //Calculates distance using distance formula for coordinates
        return Math.sqrt(Math.pow((this.x-x),2)+Math.pow((this.y-y),2));
    }

    //Static method calculates distance between two MyPoint objects
    public static double distance(MyPoint p1, MyPoint p2) {
        //Use distance formula to compute distance between p1 and p2
        return Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
    }

    //Main method tests the function of MyPoint class
    public static void main(String[] args) {
        //Create two MyPoint objects at coordinates
        MyPoint point1=new MyPoint(0, 0);
        MyPoint point2=new MyPoint(10, 30.5);

        //Calculate and display distance between the two points
        System.out.println("Distance between point 1 and point 2: "+MyPoint.distance(point1, point2));
    }
}