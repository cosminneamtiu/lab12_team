package aut.isp.lab4.exercise2;

public class FishFeeder {
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