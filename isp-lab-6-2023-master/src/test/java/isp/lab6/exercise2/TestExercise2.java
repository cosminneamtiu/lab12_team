package isp.lab6.exercise2;

import org.junit.Assert;
import org.junit.Test;

public class TestExercise2 {
    @Test
    public void TestAddVehicle(){
        VehicleRegistry registry = new VehicleRegistry();
        registry.addVehicle(new Vehicle("VIN123456789", "ABC123", "Toyota", "Camry", 2020));

        Assert.assertEquals(true, registry.isVehicleInRegistry("VIN123456789"));
    }

    @Test
    public void TestRemoveVehicle(){
        VehicleRegistry registry = new VehicleRegistry();

        registry.addVehicle(new Vehicle("VIN123456789", "ABC123", "Toyota", "Camry", 2020));
        registry.removeVehicle("VIN123456789");

        Assert.assertEquals(false, registry.isVehicleInRegistry("VIN123456789"));
    }

    @Test
    public void TestCheckVin(){
        VehicleRegistry registry = new VehicleRegistry();
        registry.addVehicle(new Vehicle("VIN123456789", "ABC123", "Toyota", "Camry", 2020));

        Assert.assertEquals(true, registry.isVehicleInRegistry("VIN123456789"));
    }
}
