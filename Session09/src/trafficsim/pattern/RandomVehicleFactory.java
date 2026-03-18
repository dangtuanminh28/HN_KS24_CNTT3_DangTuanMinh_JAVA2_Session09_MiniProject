package trafficsim.pattern;

import trafficsim.entity.*;
import trafficsim.engine.Intersection;
import java.util.Random;

public class RandomVehicleFactory implements VehicleFactory {
    private final Random rand = new Random();

    public Vehicle createVehicle(String id, Intersection intersection) {
        int type = rand.nextInt(2);
        int speed = rand.nextInt(5) + 1;

        if (type == 0)
            return new StandardVehicle(id, speed, intersection);
        else
            return new PriorityVehicle(id, speed, intersection);
    }
}
