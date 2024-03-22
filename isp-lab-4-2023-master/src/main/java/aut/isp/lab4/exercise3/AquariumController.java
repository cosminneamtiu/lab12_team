package aut.isp.lab4.exercise3;

public class AquariumController {

    //attributes
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private FishFeeder feeder;

    //constructors
    public AquariumController(String manufacturer, String model, FishFeeder feeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = 0;
        this.feedingTime = 12.30F;
        this. feeder = feeder;
    }

    public AquariumController(String manufacturer, String model, float currentTime ,FishFeeder feeder) {
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
