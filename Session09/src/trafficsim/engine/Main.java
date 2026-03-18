package trafficsim.engine;

import trafficsim.pattern.*;
import trafficsim.entity.Vehicle;

public class Main {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        TrafficLight light = new TrafficLight();

        Thread t = new Thread(light);
        t.setDaemon(true);
        t.start();

        VehicleFactory factory = new RandomVehicleFactory();

        for (int i = 0; i < 10; i++) {
            Vehicle v = factory.createVehicle("#" + i, intersection);
            light.attach(v);
            new Thread(v).start();
        }
    }
}