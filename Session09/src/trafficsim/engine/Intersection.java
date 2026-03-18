package trafficsim.engine;

import trafficsim.entity.Vehicle;
import java.util.concurrent.locks.ReentrantLock;

public class Intersection {
    private final ReentrantLock lock = new ReentrantLock();

    public void enter(Vehicle v) {
        lock.lock();
        try {
            System.out.println("[ENTER] " + v.getClass().getSimpleName() + " " + v);
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}