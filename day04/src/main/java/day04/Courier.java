package day04;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Courier {
    private List<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {

        if (!rides.isEmpty()) {
            if (ride.getDayOfWeek() < rides.get(rides.size() - 1).getDayOfWeek() ||
                    ride.getDayOfWeek() == rides.get(rides.size() - 1).getDayOfWeek() && ride.getRideNumberOfDay()+1 == rides.get(rides.size() - 1).getRideNumberOfDay()) {
                throw new IllegalArgumentException("Ride cannot be earlier than previous.");
            }
        }
        rides.add(ride);
    }

    public static void main(String[] args) {
        CourierFileManager courierFileManager = new CourierFileManager();
        Courier courier = new Courier();

        courierFileManager.createCourierByFile(Path.of("day04/src/main/resources/ride.txt"));
        for (Ride r: courierFileManager.getListScanned()) {
            courier.addRide(r);
        }

        System.out.println(courier.rides.size());
        System.out.println(courier.rides.get(courier.rides.size()-1));

    }
}
