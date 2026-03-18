package trafficsim.pattern;

public class RedState implements TrafficLightState {
    public void handle(TrafficLight light) { light.setState(new GreenState()); }
    public String getName() { return "RED"; }
}