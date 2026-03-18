package trafficsim.pattern;

import trafficsim.entity.Vehicle;
import trafficsim.engine.Intersection;

public interface VehicleFactory {
    Vehicle createVehicle(String id, Intersection intersection);
}