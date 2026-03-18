package trafficsim.pattern;

public class GreenState implements TrafficLightState {
    public void handle(TrafficLight light) { light.setState(new YellowState()); }
    public String getName() { return "GREEN"; }
}