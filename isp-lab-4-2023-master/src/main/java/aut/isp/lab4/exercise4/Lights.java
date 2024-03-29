package aut.isp.lab4.exercise4;

public class Lights {
    // Attributes
    private boolean isOn;
    private float lightOnTime;
    private float lightsOffTime;

    // Constructors
    public Lights(float lightOnTime, float lightsOffTime) {
        this.isOn = false;
        this.lightOnTime = lightOnTime;
        this.lightsOffTime = lightsOffTime;
    }

    // Methods
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Lights turned on.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Lights turned off.");
        }
    }

    // Getters and Setters
    public boolean isOn() {
        return isOn;
    }

    public float getLightOnTime() {
        return lightOnTime;
    }

    public void setLightOnTime(float lightOnTime) {
        this.lightOnTime = lightOnTime;
    }

    public float getLightsOffTime() {
        return lightsOffTime;
    }

    public void setLightsOffTime(float lightsOffTime) {
        this.lightsOffTime = lightsOffTime;
    }
}