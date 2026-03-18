package trafficsim.pattern;

public interface TrafficLightState {
    void handle(TrafficLight light);
    String getName();
}