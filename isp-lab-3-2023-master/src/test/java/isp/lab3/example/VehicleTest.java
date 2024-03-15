package isp.lab3.example;

import isp.lab3.exercise3.Vehicle;
import org.junit.Assert;
import org.junit.Test;
public class VehicleTest {
    @Test
    public void testToString(){
        Vehicle x = new Vehicle("Skoda", "Octavia", 230, 'B');

        Assert.assertEquals("Skoda (Octavia) speed 230 fuel type B", x.toString());
    }
}

