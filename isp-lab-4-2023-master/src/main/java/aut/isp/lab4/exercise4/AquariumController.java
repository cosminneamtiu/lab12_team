package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise4.FishFeeder;

public class AquariumController {

    // Attributes
    private String manufacturer;
    private String model;
    private float currentTime;
    private float feedingTime;
    private FishFeeder feeder;
    private Lights lights;

    // Constructors
    public AquariumController(String manufacturer, String model, FishFeeder feeder, Lights lights) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = 0;
        this.feedingTime = 12.30F;
        this.feeder = feeder;
        this.lights = lights;
    }

    public AquariumController(String manufacturer, String model, float currentTime, FishFeeder feeder, Lights lights) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = 12.30F;
        this.feeder = feeder;
        this.lights = lights;
    }

    public AquariumController(String manufacturer, String model, float currentTime, float feedingTime, FishFeeder feeder, Lights lights) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.feeder = feeder;
        this.lights = lights;
    }

    // Methods
    public void setCurrentTime(float currentTime) {
        this.currentTime = currentTime;

        // Check if it's feeding time
        if (currentTime == this.feedingTime) {
            this.feeder.feed();
        }

        // Check if it's time to turn the lights on or off
        if (currentTime >= this.lights.getLightOnTime() && currentTime < this.lights.getLightsOffTime()) {
            if (!this.lights.isOn()) {
                this.lights.turnOn();
            }
        } else {
            if (this.lights.isOn()) {
                this.lights.turnOff();
            }
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
                ", lights = " + lights +
                "}";
    }
}
