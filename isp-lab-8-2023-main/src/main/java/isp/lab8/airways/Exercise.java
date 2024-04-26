package isp.lab8.airways;

import java.io.*;
import java.util.*;

class RouteManager {
    private String routesDirectory;

    public RouteManager(String routesDirectory) {
        this.routesDirectory = routesDirectory;
    }

    public void createRoute(String routeName) {
        File routeFolder = new File(routesDirectory + File.separator + routeName);
        routeFolder.mkdir();
    }

    public void deleteRoute(String routeName) {
        File routeFolder = new File(routesDirectory + File.separator + routeName);
        if (routeFolder.exists()) {
            File[] files = routeFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            routeFolder.delete();
        }
    }

    public List<String> listRoutes() {
        List<String> routeNames = new ArrayList<>();
        File[] files = new File(routesDirectory).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    routeNames.add(file.getName());
                }
            }
        }
        return routeNames;
    }

    public void saveWaypoint(String routeName, WayPoint waypoint) {
        // Save the waypoint as a separate file inside the route's folder
        try (FileOutputStream fileOut = new FileOutputStream(routesDirectory + File.separator + routeName + File.separator + waypoint.getName() + ".ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(waypoint);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<WayPoint> loadWaypoints(String routeName) {
        List<WayPoint> waypoints = new ArrayList<>();
        File[] files = new File(routesDirectory + File.separator + routeName).listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".ser")) {
                    try (FileInputStream fileIn = new FileInputStream(file);
                         ObjectInputStream in = new ObjectInputStream(fileIn)) {
                        waypoints.add((WayPoint) in.readObject());
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return waypoints;
    }

    public double calculateTotalDistance(String routeName) {
        List<WayPoint> waypoints = loadWaypoints(routeName);
        double totalDistance = 0.0;
        for (int i = 0; i < waypoints.size() - 1; i++) {
            totalDistance += calculateDistance(waypoints.get(i), waypoints.get(i + 1));
        }
        return totalDistance;
    }

    private double calculateDistance(WayPoint wp1, WayPoint wp2) {
        double lat1 = wp1.getLatitude();
        double lat2 = wp2.getLatitude();
        double lon1 = wp1.getLongitude();
        double lon2 = wp2.getLongitude();
        // distance between latitudes and longitudes
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
    }
}


public class Exercise {
    public static void main(String[] args) {
        RouteManager routeManager = new RouteManager("E:\\University\\SE\\se-eng-2024-DLaszlo2003\\isp-lab-8-2023-main\\routes\\");

        routeManager.createRoute("LRCL-LROP");

        routeManager.saveWaypoint("LRCL-LROP", new WayPoint(1,"LRCL", 46.7852, 23.6862, 415));
        routeManager.saveWaypoint("LRCL-LROP", new WayPoint(2,"TASOD", 47.0548, 23.9219, 10460));
        routeManager.saveWaypoint("LRCL-LROP", new WayPoint(3,"SOPAV", 46.9804, 24.7365, 10900));
        routeManager.saveWaypoint("LRCL-LROP", new WayPoint(4,"BIRGU", 45.9467, 26.0217, 10200));
        routeManager.saveWaypoint("LRCL-LROP", new WayPoint(5,"LROP", 44.5711, 26.0858, 106));


        double totalDistance = routeManager.calculateTotalDistance("LRCL-LROP");
        System.out.println("Total distance of LRCL-LROP route: " + totalDistance);


        List<String> routes = routeManager.listRoutes();
        for (String routeName : routes) {
            System.out.println(routeName);
        }


        routeManager.deleteRoute("LRCL-LROP");
    }
}
