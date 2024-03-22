package aut.isp.lab4.exercise4;

public class FishFeeder{
    //attributes
    private String manufacturer;
    private String model;
    private int meals;

    //consturctors
    public FishFeeder(String manufacturer, String model){
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = 14;
    }

    public FishFeeder(String manufacturer, String model, int meals){
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }
    //methods
    public void feed(){
        this.meals -= 1;
        System.out.println("The fishes have been feeded! Meals remaining: " + meals);
    }
    public void fillUp(){
        this.meals = 14;
        System.out.println("The Fish Feeder has been filled up.");
    }
    public String toString(){
        return "Feeder{"+
                "manufacturer = " + manufacturer +
                ", model = " + model +
                ", meals = " + meals +
                "}";
    }
}
