package trafficsim.entity;

import trafficsim.engine.Intersection;

public class PriorityVehicle extends Vehicle {
    public PriorityVehicle(String id, int speed, Intersection intersection) {
        super(id, speed, intersection);
    }
    public int getPriority() { return 10; }

    @Override
    public void run() {
        try {
            Thread.sleep(speed * 100);
            intersection.enter(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
