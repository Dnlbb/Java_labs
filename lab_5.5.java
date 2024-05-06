import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class BusFleet {
    HashMap<Integer, List<Bus>> busesOnRoutes;

    BusFleet() {
        busesOnRoutes = new HashMap<>();
    }

    void addBus(Bus bus) {
        if (bus.routeNumber >= 0) {
            busesOnRoutes.computeIfAbsent(bus.routeNumber, k -> new ArrayList<>()).add(bus);
        }
    }

    public Stream<Bus> nearestBusesStream(int k, double latitude, double longitude) {
        return busesOnRoutes.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingDouble(bus -> distance(bus.latitude, bus.longitude, latitude, longitude)))
                .limit(k);
    }

    public int calculateMinimumDrivers(int passengers) {
        int driversNeeded = 0;
        int remainingPassengers = passengers;

        List<Bus> sortedBuses = busesOnRoutes.values().stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparingInt(bus -> -bus.capacity))
                .collect(Collectors.toList());

        for (Bus bus : sortedBuses) {
            if (remainingPassengers <= 0) break;
            remainingPassengers -= bus.capacity;
            driversNeeded++;
        }

        return driversNeeded;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        return Math.sqrt(Math.pow(lat2 - lat1, 2) + Math.pow(lon2 - lon1, 2));
    }
}
