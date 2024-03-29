package isp.lab5.exercise2;

public class Smartphone implements Chargeable{
    private int batteryLevel;

    public Smartphone(int batteryLevel){
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void charge(int duration){
        //90 mins to fully charge from 0 to 100
        this.batteryLevel = this.batteryLevel+duration*100/90;
        if(this.batteryLevel > 100)
            this.batteryLevel = 100;
    }

    @Override
    public int getBatteryLevel() {
        return this.batteryLevel;
    }
}
