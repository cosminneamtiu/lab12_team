package isp.lab5.exercise2;

import isp.lab5.exercise1.*;
import org.junit.Assert;
import org.junit.Test;

public class Exercise2Test {
    @Test
    public void charge(){
        Laptop laptop1 = new Laptop(50);
        laptop1.charge(27);

        Assert.assertEquals(72, laptop1.getBatteryLevel());
    }

}
