package trafficsim.pattern;

public class YellowState implements TrafficLightState {
    public void handle(TrafficLight light) { light.setState(new RedState()); }
    public String getName() { return "YELLOW"; }
}