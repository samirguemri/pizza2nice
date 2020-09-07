package edu.samir.pizza2nice.model;

import java.util.Arrays;
import java.util.List;

public enum Area {
    ZONE_A,
    ZONE_B,
    ZONE_C,
    ZONE_D,
    HORS_ZONE;

    public static List<Area> getFields(){
        return Arrays.asList(Area.values());
    }
}
