package isp.lab3.exercise3;


public class Vehicle {
    //attributes
    private String model;
    private String type;
    private int speed;
    private char fuelType;
    private static int numVehicles = 0;

    //constructors
    public Vehicle(String model, String type, int speed, char fuelType){
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.fuelType = fuelType;
        numVehicles++;
    }

    //methods
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type= type;
    }

    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public char getFuelType() {
        return fuelType;
    }
    public void setFuelType(char fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return model + " (" + type + ") speed " + speed + " fuel type " + fuelType;
    }

    public static void displayNumVehicles() {
        System.out.println("Number of vehicles created: " + numVehicles);
    }

    //main method
    public static void main(String args[]){
        Vehicle x,y;
        x = new Vehicle("VW", "Passat", 280, 'D');
        y = new Vehicle("Porsche", "Carrera", 465, 'D');

        x.setModel("Volkswagen");
        System.out.println("getModel():");
        System.out.println("x: " + x.getModel());
        System.out.println("y: " + y.getModel());

        y.setType("911R");
        System.out.println("\ngetType():");
        System.out.println("x: " + x.getType());
        System.out.println("y: " + y.getType());

        x.setSpeed(298);
        System.out.println("\ngetSpeed():");
        System.out.println("x: " + x.getSpeed());
        System.out.println("y: " + y.getSpeed());

        y.setFuelType('B');
        System.out.println("\ngetFuelType():");
        System.out.println("x: " + x.getFuelType());
        System.out.println("y: " + y.getFuelType());

        System.out.println("\ntoString():");
        System.out.println(x.toString());
        System.out.println(y.toString());


        boolean equal = x.equals(y);
        if(equal)
            System.out.println("\nThe two vehicles are the same!\n");
        else
            System.out.println("\nThe two vehicles are NOT the same!\n");


        displayNumVehicles();

    }
}
