package isp.lab10.exercise1;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class ATC {
    private List<Aircraft> aircrafts = new ArrayList<>();
    private Object lock = new Object();

    public void addAircraft(String id) {
        Aircraft aircraft = new Aircraft(id, lock);
        aircrafts.add(aircraft);
        aircraft.start();
        System.out.println("Aircraft with id " + id + " added");
    }

    public void sendCommand(String id, AtcCommand command) {
        for (Aircraft aircraft : aircrafts) {
            if (aircraft.getId().equals(id)) {
                aircraft.receiveAtcCommand(command);
                System.out.println("Aircraft with id " + id + " received command " + command);
                return;
            }
        }
        System.out.println("No aircraft found with id " + id);
    }

    public void showAircrafts() {
        System.out.println("Display aircrafts:");
        for (Aircraft aircraft : aircrafts) {
            System.out.println("Aircraft ID: " + aircraft.getId() + ", Altitude: " + aircraft.getAltitude());
        }
    }

    public List<Aircraft> getAircrafts() {
        return aircrafts;
    }
}


abstract class AtcCommand {
    public abstract void execute(Aircraft aircraft);
}

class TakeoffCommand extends AtcCommand {
    int altitude;

    public TakeoffCommand(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public void execute(Aircraft aircraft) {
        aircraft.receiveTakeoffCommand(this);
    }

    @Override
    public String toString() {
        return "TakeoffCommand{" +
                "altitude=" + altitude +
                '}';
    }
}

class LandCommand extends AtcCommand {
    @Override
    public void execute(Aircraft aircraft) {
        aircraft.receiveLandCommand(this);
    }

    @Override
    public String toString() {
        return "LandCommand{}";
    }
}
