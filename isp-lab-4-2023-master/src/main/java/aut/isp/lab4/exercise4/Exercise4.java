package aut.isp.lab4.exercise4;

import aut.isp.lab4.exercise4.AquariumController;
import aut.isp.lab4.exercise4.FishFeeder;

public class Exercise4 {
    public static void main(String[] args) {
        FishFeeder fishy = new FishFeeder("LilFish", "Pipo");
        Lights lights = new Lights(8.0F, 18.0F);
        AquariumController controller = new AquariumController("BigAqua", "Ming", fishy, lights);

        System.out.println("Setting current time to 7:00 AM:");
        controller.setCurrentTime(7.0F);

        System.out.println("\nSetting current time to 12:30 PM (feeding time):");
        controller.setCurrentTime(12.30F);

        System.out.println("\nSetting current time to 9:00 PM:");
        controller.setCurrentTime(21.0F);
    }
}
