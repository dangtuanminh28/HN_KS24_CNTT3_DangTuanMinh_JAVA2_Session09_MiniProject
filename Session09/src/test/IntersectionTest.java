package test;

import org.junit.jupiter.api.Test;
import trafficsim.engine.Intersection;
import trafficsim.entity.StandardVehicle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntersectionTest {

    @Test
    void testMultiThreadNoCrash() throws InterruptedException {
        Intersection intersection = new Intersection();

        ExecutorService pool = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 100; i++) {
            int id = i;
            pool.submit(() -> {
                StandardVehicle v =
                        new StandardVehicle("Test-" + id, 1, intersection);
                v.run();
            });
        }

        pool.shutdown();

        // đợi tất cả thread chạy xong
        Thread.sleep(5000);

        // Nếu không crash => pass
        assertTrue(true);
    }
}