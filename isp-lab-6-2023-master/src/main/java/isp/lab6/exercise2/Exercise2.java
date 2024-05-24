package isp.lab6.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry();

        // Adding vehicles
        registry.addVehicle(new Vehicle("VIN123456789", "ABC123", "Toyota", "Camry", 2020));
        registry.addVehicle(new Vehicle("VIN987654321", "XYZ789", "Honda", "Civic", 2018));
        registry.displayRegistry();

        // Removing a vehicle
        registry.removeVehicle("VIN123456789");
        registry.displayRegistry();

        // Checking if a vehicle is in the registry
        System.out.println("Is VIN123456789 in the registry? " + registry.isVehicleInRegistry("VIN123456789"));
        System.out.println("Is VIN987654321 in the registry? " + registry.isVehicleInRegistry("VIN987654321"));

        // Displaying the registry
        registry.displayRegistry();
    }
}
