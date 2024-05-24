package aut.isp.lab4.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder fishy = new FishFeeder("LilFish", "Pipo");
        AquariumController Controller1 = new AquariumController("BigAqua", "Ming", 12.45F, 12.30F, fishy);
        Controller1.setCurrentTime(12.30F);
        Controller1.setFeedingTime(11.48F);
        Controller1.setCurrentTime(11.48F);
        System.out.println(Controller1.toString());
    }
}
