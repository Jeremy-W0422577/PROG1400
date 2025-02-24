public class Fan {
    //Constants for fan speed
    public static final int SLOW=1;
    public static final int MEDIUM=2;
    public static final int FAST=3;

    //Data fields
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    //No-arg constructor that creates a fan
    public Fan() {
        this.speed=SLOW;
        this.on=false;
        this.radius=5;
        this.color="blue";
    }

    //Accessor and mutator methods
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed=speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on=on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius=radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color=color;
    }

    //Method to return a string description of the fan
    @Override
    public String toString() {
        if (on) {
            return "Fan speed: "+speed+", Color: "+color+", Radius: "+radius;
        } else {
            return color+" fan (Radius: "+radius+") is off";
        }
    }

    public static void main(String[] args) {
        //Create the first Fan
        Fan fan1=new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true); //Turn it on

        //Create the second Fan
        Fan fan2=new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false); //Turn it off

        //Display the fan information using toString()
        System.out.println(fan1.toString()); //Details of fan1
        System.out.println(fan2.toString()); //Details of fan2
    }
}