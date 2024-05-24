package isp.lab7.safehome;


import java.util.ArrayList;
import java.util.List;

class InvalidPinException extends Exception {
    InvalidPinException(String message) {
        super(message);
    }
}

class TooManyAttemptsException extends Exception {
    TooManyAttemptsException(String message) {
        super(message);
    }
}

class TenantAlreadyExistsException extends Exception {
    TenantAlreadyExistsException(String message) {
        super(message);
    }
}

class TenantNotFoundException extends Exception {
    TenantNotFoundException(String message) {
        super(message);
    }
}

class DoorController implements ControllerInterface {
    private DoorStatus doorStatus;
    private int retryCount;
    private List<Tenant> tenants;
    private List<String> accessLogs;

    DoorController() {
        doorStatus = DoorStatus.CLOSE;
        retryCount = 0;
        tenants = new ArrayList<>();
        accessLogs = new ArrayList<>();
    }

    @Override
    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
        if (doorStatus == DoorStatus.OPEN) {
            doorStatus = DoorStatus.CLOSE;
        } else {
            if (pin.equals(MASTER_KEY)) {
                retryCount = 0;
                doorStatus = DoorStatus.OPEN;
                accessLogs.add("Master key used to unlock the door.");
            } else {
                boolean tenantFound = false;
                for (Tenant tenant : tenants) {
                    if (tenant.getPin().equals(pin)) {
                        if (retryCount >= 3) {
                            doorStatus = DoorStatus.CLOSE;
                            throw new TooManyAttemptsException("Too many failed attempts. Door locked.");
                        }else {
                            retryCount = 0;
                            doorStatus = DoorStatus.OPEN;
                            accessLogs.add("Pin entered by " + tenant.getName());
                            tenantFound = true;
                            break;
                        }
                    }
                }
                if (!tenantFound) {
                    retryCount++;
                    if (retryCount >= 3) {
                        doorStatus = DoorStatus.CLOSE;
                        throw new TooManyAttemptsException("Too many failed attempts. Door locked.");
                    } else {
                        throw new InvalidPinException("Incorrect pin entered.");
                    }
                }
            }
        }
        return doorStatus;
    }

    @Override
    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
        for (Tenant tenant : tenants) {
            if (tenant.getName().equals(name)) {
                throw new TenantAlreadyExistsException("Tenant already exists.");
            }
        }
        tenants.add(new Tenant(pin, name));
    }

    @Override
    public void removeTenant(String name) throws TenantNotFoundException {
        boolean tenantFound = false;
        for (Tenant tenant : tenants) {
            if (tenant.getName().equals(name)) {
                tenants.remove(tenant);
                tenantFound = true;
                if (doorStatus == DoorStatus.OPEN) {
                    doorStatus = DoorStatus.CLOSE;
                }
                break;
            }
        }
        if (!tenantFound) {
            throw new TenantNotFoundException("Tenant not found.");
        }
    }
}

class Tenant {
    private String pin;
    private String name;

    Tenant(String pin, String name) {
        this.pin = pin;
        this.name = name;
    }

    String getPin() {
        return pin;
    }

    String getName() {
        return name;
    }
}


public class SafeHome {

    static ControllerInterface ctrl = new DoorController();

    public static void main(String[] args) throws Exception {
        try {
            ctrl.addTenant("12345", "User1");
            System.out.println("Tenant successfully created");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        ctrl.enterPin("12345");

        ctrl.removeTenant("User1");
        System.out.println("Tenant successfully removed");
        try {
            ctrl.enterPin("12345");
            System.out.println("Successfully opened the door");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
