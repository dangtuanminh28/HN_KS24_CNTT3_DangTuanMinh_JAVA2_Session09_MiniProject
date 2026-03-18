package trafficsim.entity;

import trafficsim.pattern.TrafficObserver;
import trafficsim.engine.Intersection;

public abstract class Vehicle implements Runnable, TrafficObserver {
    protected String id;
    protected int speed;
    protected String currentLight = "RED";
    protected Intersection intersection;

    public Vehicle(String id, int speed, Intersection intersection) {
        this.id = id;
        this.speed = speed;
        this.intersection = intersection;
    }

    public abstract int getPriority();

    @Override
    public void onSignalChange(String state) {
        this.currentLight = state;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(speed * 100);
            while (!currentLight.equals("GREEN")) {
                Thread.sleep(200);
            }
            intersection.enter(this);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}