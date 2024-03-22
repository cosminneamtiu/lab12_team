package aut.isp.lab4.exercise1;

import aut.isp.lab4.exercise0.Car;
import aut.isp.lab4.exercise0.CarAlarm;
import aut.isp.lab4.exercise0.Engine;

public class AquariumController {

    //attributes
    private String manufacturer;
    private String model;
    private float currentTime;

    //constructors
    public AquariumController(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = 0;
    }

    public AquariumController(String manufacturer, String model, float currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    //methods
    public void setCurrentTime(float currentTime){
        this.currentTime = currentTime;
    }

    @Override
    public String toString(){
        return "Controller{"+
                "manufacturer = " + manufacturer +
                ", model = " + model +
                ", currentTime = " + currentTime +
                "}";
    }
}
