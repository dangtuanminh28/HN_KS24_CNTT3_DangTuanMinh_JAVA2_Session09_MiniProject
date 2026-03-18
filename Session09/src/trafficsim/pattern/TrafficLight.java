package trafficsim.pattern;

import java.util.*;

public class TrafficLight implements Runnable {
    private TrafficLightState state = new RedState();
    private final List<TrafficObserver> observers = new ArrayList<>();

    public void attach(TrafficObserver o) { observers.add(o); }

    public void notifyObservers() {
        for (TrafficObserver o : observers) {
            o.onSignalChange(state.getName());
        }
    }

    public synchronized void setState(TrafficLightState state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(3000);
                state.handle(this);
                System.out.println("[LIGHT] " + state.getName());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}