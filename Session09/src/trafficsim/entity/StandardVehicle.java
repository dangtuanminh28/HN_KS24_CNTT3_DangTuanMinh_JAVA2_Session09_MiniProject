package trafficsim.entity;

import trafficsim.engine.Intersection;

public class StandardVehicle extends Vehicle {
    public StandardVehicle(String id, int speed, Intersection intersection) {
        super(id, speed, intersection);
    }
    public int getPriority() { return 1; }
}