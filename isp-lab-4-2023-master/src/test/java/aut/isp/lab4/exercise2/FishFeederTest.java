package aut.isp.lab4.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class FishFeederTest {
    @Test
    public void testToString(){
        FishFeeder x = new FishFeeder("BigAqua", "215");

        Assert.assertEquals("Feeder{manufacturer = BigAqua, model = 215, meals = 14}", x.toString());
    }

    @Test
    public void feed(){
        FishFeeder x = new FishFeeder("BigAqua", "215");
        x.feed();
        Assert.assertEquals("Feeder{manufacturer = BigAqua, model = 215, meals = 13}", x.toString());
    }

    @Test
    public void fillUp(){
        FishFeeder x = new FishFeeder("BigAqua", "215", 9);
        x.fillUp();
        Assert.assertEquals("Feeder{manufacturer = BigAqua, model = 215, meals = 14}", x.toString());
    }
}
