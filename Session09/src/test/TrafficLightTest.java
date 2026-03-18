package test;

import org.junit.jupiter.api.Test;
import trafficsim.pattern.*;

import static org.junit.jupiter.api.Assertions.*;

public class TrafficLightTest {

    @Test
    void testStateTransition() {
        TrafficLight light = new TrafficLight();

        // Ban đầu là RED
        assertEquals("RED", getState(light));

        // RED -> GREEN
        light.setState(new GreenState());
        assertEquals("GREEN", getState(light));

        // GREEN -> YELLOW
        light.setState(new YellowState());
        assertEquals("YELLOW", getState(light));

        // YELLOW -> RED
        light.setState(new RedState());
        assertEquals("RED", getState(light));
    }

    // helper để lấy state (vì state private)
    private String getState(TrafficLight light) {
        try {
            var field = TrafficLight.class.getDeclaredField("state");
            field.setAccessible(true);
            TrafficLightState state = (TrafficLightState) field.get(light);
            return state.getName();
        } catch (Exception e) {
            return null;
        }
    }
}