package aut.isp.lab4.exercise1;

import org.junit.Assert;
import org.junit.Test;

public class AquariumControllerTest {
    //implement minimal tests
    @Test
    public void testToString(){
        AquariumController x = new AquariumController("BigAqua", "215", 13.2F);

        Assert.assertEquals("Controller{manufacturer = BigAqua, model = 215, currentTime = 13.2}", x.toString());
    }

    @Test
    public void testSetCurrentTime(){
        AquariumController x = new AquariumController("BigAqua", "215", 13.2F);
        x.setCurrentTime(12.8F);
        Assert.assertEquals("Controller{manufacturer = BigAqua, model = 215, currentTime = 12.8}", x.toString());
    }

}
