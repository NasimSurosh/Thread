package trafic_light;

import java.util.Random;
public class TrafficIntersectionSimulation {
    public static void main(String[] args) {
        TrafficLane northSouthLane = new TrafficLane("North-South Lane");
        TrafficLane eastWestLane = new TrafficLane("East-West Lane");
        TrafficLane diagonalLane = new TrafficLane("Diagonal Lane");
        northSouthLane.start();
        eastWestLane.start();
        diagonalLane.start();
    }
}
class TrafficLane extends Thread {
    public TrafficLane(String name) {
        super(name);
    }
    @Override
    public void run() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ": Vehicle " + i + " enters the intersection.");
            try {
                sleep(500); // Simulate vehicle arrivals at different times
            } catch (InterruptedException e) {
                System.out.println(getName() + " was interrupted.");
            }
        }
    }
}
