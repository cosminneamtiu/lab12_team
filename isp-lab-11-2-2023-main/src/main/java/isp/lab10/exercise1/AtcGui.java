package isp.lab10.exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtcGui {
    private ATC atc;
    private JFrame frame;
    private JTextArea outputArea;

    public AtcGui() {
        atc = new ATC();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("ATC System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout(5, 1));

        JButton btnAddAircraft = new JButton("Add Aircraft");
        btnAddAircraft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "Enter Aircraft ID:");
                if (id != null && !id.trim().isEmpty()) {
                    atc.addAircraft(id);
                    outputArea.append("Aircraft with ID " + id + " added.\n");
                }
            }
        });
        panel.add(btnAddAircraft);

        JButton btnTakeoff = new JButton("Takeoff Command");
        btnTakeoff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "Enter Aircraft ID:");
                if (id != null && !id.trim().isEmpty()) {
                    String altitudeStr = JOptionPane.showInputDialog(frame, "Enter Takeoff Altitude:");
                    try {
                        int altitude = Integer.parseInt(altitudeStr);
                        atc.sendCommand(id, new TakeoffCommand(altitude));
                        outputArea.append("Takeoff command sent to Aircraft " + id + " with altitude " + altitude + ".\n");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid altitude value.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(btnTakeoff);

        JButton btnLand = new JButton("Land Command");
        btnLand.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = JOptionPane.showInputDialog(frame, "Enter Aircraft ID:");
                if (id != null && !id.trim().isEmpty()) {
                    atc.sendCommand(id, new LandCommand());
                    outputArea.append("Land command sent to Aircraft " + id + ".\n");
                }
            }
        });
        panel.add(btnLand);

        JButton btnShowAircrafts = new JButton("Show Aircrafts");
        btnShowAircrafts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Displaying aircrafts:\n");
                for (Aircraft aircraft : atc.getAircrafts()) {
                    outputArea.append("Aircraft ID: " + aircraft.getId() + ", Altitude: " + aircraft.getAltitude() + "\n");
                }
            }
        });
        panel.add(btnShowAircrafts);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(btnExit);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AtcGui();
            }
        });
    }
}
