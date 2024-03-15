package isp.lab3.exercise2;

import isp.lab3.exercise1.Tree;

public class Rectangle {
    //attributes
    int length;
    int width;
    String color;

    //constructors
    public Rectangle(){
        length = 2;
        width = 1;
        color = "red";
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.color = "red";
    }

    public Rectangle(int length, int width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    //methods
    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public int getArea() {
        return length * width;
    }

    //main method
    public static void main(String[] args){
        Rectangle x,y,z;
        x = new Rectangle();
        y = new Rectangle(2,4);
        z = new Rectangle(1,2,"blue");

        System.out.println("getLength():");
        System.out.println("x: " + x.getLength());
        System.out.println("y: " + y.getLength());
        System.out.println("z: " + z.getLength());

        System.out.println("getWidth():");
        System.out.println("x: " + x.getWidth());
        System.out.println("y: " + y.getWidth());
        System.out.println("z: " + z.getWidth());

        System.out.println("getPerimeter():");
        System.out.println("x: " + x.getPerimeter());
        System.out.println("y: " + y.getPerimeter());
        System.out.println("z: " + z.getPerimeter());

        System.out.println("getArea():");
        System.out.println("x: " + x.getArea());
        System.out.println("y: " + y.getArea());
        System.out.println("z: " + z.getArea());

        System.out.println("getColor():");
        System.out.println("x: " + x.getColor());
        System.out.println("y: " + y.getColor());
        System.out.println("z: " + z.getColor());


    }
}
