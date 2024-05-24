package isp.lab5.exercise3;

abstract class Sensor {
    String installLocation;
    String name;

    public Sensor(String installLocation, String name){
        this.installLocation = installLocation;
        this.name =  name;
    }

}

class TemperatureSensor extends Sensor{
    double temperature;
    public TemperatureSensor(String installLocation, String name, double temperature) {
        super(installLocation, name);
        this.temperature = temperature;
    }
}

class PressureSensor extends Sensor{
    double pressure;
    public PressureSensor(String installLocation, String name, double pressure) {
        super(installLocation, name);
        this.pressure = pressure;
    }
}
