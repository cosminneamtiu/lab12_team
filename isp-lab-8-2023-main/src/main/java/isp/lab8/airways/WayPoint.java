package isp.lab8.airways;

/**
 * Example waypoint class which can be extended to be used in implementation of the exercise. Add constructor, getters, setters, etc.
 */
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.*;

@AllArgsConstructor
public class WayPoint implements Serializable{
    @Getter @Setter
    private int index;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private double latitude;
    @Getter @Setter
    private double longitude;
    @Getter @Setter
    private int altitude;
}
