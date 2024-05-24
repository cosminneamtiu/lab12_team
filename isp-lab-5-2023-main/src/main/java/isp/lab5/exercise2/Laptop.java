package isp.lab5.exercise2;

public class Laptop implements Chargeable{
   private int batteryLevel;

   public Laptop(int batteryLevel){
       this.batteryLevel = batteryLevel;
   }

    @Override
    public void charge(int duration){
        //120 mins to fully charge from 0 to 100
        this.batteryLevel = this.batteryLevel+duration*100/120;
        if(this.batteryLevel > 100)
            this.batteryLevel = 100;
    }

    @Override
    public int getBatteryLevel() {
        return this.batteryLevel;
    }
}
