package isp.lab10.raceapp;

import javax.swing.*;

import static java.util.Collections.swap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Race!");

        JFrame semaphoreFrame = new JFrame("Semaphore");
        semaphoreFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SemaphorePanel semaphorePanel = new SemaphorePanel();
        semaphoreFrame.getContentPane().add(semaphorePanel);
        semaphoreFrame.pack();
        semaphoreFrame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();

        try {
            semaphoreThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PlaySound playSound = new PlaySound();
        playSound.playSound();

        JFrame carRaceFrame = new JFrame("Car Race");
        carRaceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarPanel carPanel = new CarPanel();
        carRaceFrame.getContentPane().add(carPanel);
        carRaceFrame.pack();
        carRaceFrame.setSize(500, 300);
        carRaceFrame.setVisible(true);

        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);

        TimerThread timerThread = new TimerThread();
        timerThread.start();

        car1.start();
        car2.start();
        car3.start();
        car4.start();

        try {
            car1.join();
            car2.join();
            car3.join();
            car4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timerThread.stopTimer();

        playSound.stopSound();

        String[] carStandings = new String[4];
        carStandings[0] = "Red car";
        carStandings[1] = "Blue car";
        carStandings[2] = "Green car";
        carStandings[3] = "Yellow car";

        long[] rcDur = new long[4];
        rcDur[0] = car1.getRaceDuration();
        rcDur[1] = car2.getRaceDuration();
        rcDur[2] = car3.getRaceDuration();
        rcDur[3] = car4.getRaceDuration();

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (rcDur[i] > rcDur[j]) {
                    long swap = rcDur[j];
                    rcDur[j] = rcDur[i];
                    rcDur[i] = swap;

                    String swap1 = carStandings[j];
                    carStandings[j] = carStandings[i];
                    carStandings[i] = swap1;
                }
            }
        }



        String[] standings = new String[4];
        standings[0] = carStandings[0] + " - " + rcDur[0]/1000.0 + " s";
        standings[1] = carStandings[1] + " - " + rcDur[1]/1000.0 + " s";
        standings[2] = carStandings[2] + " - " + rcDur[2]/1000.0 + " s";
        standings[3] = carStandings[3] + " - " + rcDur[3]/1000.0 + " s";

        JOptionPane.showMessageDialog(null, "Race Standings:\n1. " + standings[0] + "\n2. " + standings[1] +
                "\n3. " + standings[2] + "\n4. " + standings[3]);

        System.out.println("Race Duration for each Car:");
        for (String standing : standings) {
            System.out.println(standing);
        }
    }
}