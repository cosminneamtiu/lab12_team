package aut.isp.lab4.exercise3;

import org.junit.Assert;
import org.junit.Test;

public class CombinedTest {
    @Test
    public void testToString(){
        FishFeeder x = new FishFeeder("LilFish", "Pipo");
        AquariumController Controller1 = new AquariumController("BigAqua", "Ming", 12.45F, 12.30F, x);

        Assert.assertEquals("Controller{manufacturer = BigAqua, model = Ming, currentTime = 12.45, feedingTime = 12.3, feeder = Feeder{manufacturer = LilFish, model = Pipo, meals = 14}}", Controller1.toString());
    }

    @Test
    public void setCurrentTime(){
        FishFeeder x = new FishFeeder("LilFish", "Pipo");
        AquariumController Controller1 = new AquariumController("BigAqua", "Ming", 12.45F, 12.30F, x);
        Controller1.setCurrentTime(12.30F);
        Assert.assertEquals("Controller{manufacturer = BigAqua, model = Ming, currentTime = 12.3, feedingTime = 12.3, feeder = Feeder{manufacturer = LilFish, model = Pipo, meals = 13}}", Controller1.toString());
    }
}
