package isp.lab10.exercise1;

public class Aircraft implements Runnable{
    String id;
    int altitude;
    int cruisingAltitude;
    Object lock;
    long cruisingStartTime;
    long cruiseDuration;

    public Aircraft(String id, Object lock){
        this.id = id;
        this.altitude = 0;
        this.lock = lock;
    }

    public String getId() {
        return id;
    }

    public int getAltitude() {
        return altitude;
    }

    public void receiveTakeoffCommand(TakeoffCommand cmd) {
        synchronized (lock) {
            cruisingAltitude = cmd.altitude;
            lock.notify();
        }
    }

    public void receiveLandCommand(LandCommand cmd) {
        synchronized (lock) {
            cruisingAltitude = 0;
            lock.notify();
        }
    }

    public void receiveAtcCommand(AtcCommand cmd) {
        cmd.execute(this);
    }

    public void start(){
        Thread t = new Thread(this);
        t.start();
    }
    public void run(){
        System.out.println(id + " is on stand");
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(id + " is taxing");
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id + " is taking off");
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id + " started ascending");
        try {
            while(altitude<cruisingAltitude) {
                Thread.sleep(10 * 1000);
                altitude+=1;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id + " is cruising");
        cruisingStartTime = System.currentTimeMillis();

        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        cruiseDuration = System.currentTimeMillis() - cruisingStartTime;
        System.out.println(id + " started descending");
        try {
            while(altitude>0) {
                Thread.sleep(10 * 1000);
                altitude-=1;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(id + " landed");
        System.out.println(id + " was cruising for " + cruiseDuration/1000.0 + " seconds.");
    }
}

class Main {
    public static void main(String[] args) {
        Object lock = new Object();

        Aircraft aircraft1 = new Aircraft("Flight-123", lock);
        Aircraft aircraft2 = new Aircraft("Flight-234", lock);
        Aircraft aircraft3 = new Aircraft("Flight-345", lock);

        aircraft1.start();
        aircraft2.start();
        aircraft3.start();

        try {
            Thread.sleep(2000);
            aircraft1.receiveAtcCommand(new TakeoffCommand(2));
            aircraft2.receiveAtcCommand(new TakeoffCommand(4));
            aircraft3.receiveAtcCommand(new TakeoffCommand(3));


            Thread.sleep(60000);
            aircraft1.receiveAtcCommand(new LandCommand());
            aircraft2.receiveAtcCommand(new LandCommand());
            aircraft3.receiveAtcCommand(new LandCommand());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
