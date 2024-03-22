package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise3.FishFeeder;

public class AquariumController {

    //attributes
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private FishFeeder feeder;

    private static float lightOnTime = 10.00F;
    private static float lightOffTime = 17.59F;

    boolean light = false;

    //constructors
    public AquariumController(String manufacturer, String model, aut.isp.lab4.exercise3.FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = 0;
        this.feedingTime = 12.30F;
        this. feeder = feeder;
    }

    public AquariumController(String manufacturer, String model, float currentTime , aut.isp.lab4.exercise3.FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = 12.30F;
        this. feeder = feeder;
    }

    public AquariumController(String manufacturer, String model, float currentTime , float feedingTime, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this. feeder = feeder;
    }

    //methods
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;
        if(currentTime == this.feedingTime){
            this.feeder.feed();
        }
        if(this.currentTime>=this.lightOnTime && this.currentTime<=this.lightOffTime){
            light = true;
        }else{
            light = false;
        }
    }

    public void setFeedingTime(float feedingTime) {
        this.feedingTime = feedingTime;

    }

    @Override
    public String toString() {
        return "Controller{" +
                "manufacturer = " + manufacturer +
                ", model = " + model +
                ", currentTime = " + currentTime +
                ", feedingTime = " + feedingTime +
                ", feeder = " + feeder +
                "}";
    }
}
