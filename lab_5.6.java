public class Test3 {
    public static void main(String[] args) {
        BusFleet fleet = new BusFleet();
        fleet.addBus(new Bus(50, 1, 10.0, 0));
        fleet.addBus(new Bus(30, 2, 20.0, 0));
        fleet.addBus(new Bus(20, 3,30.0, 0));
        fleet.nearestBusesStream(3, 15.0, 15.0).forEach(bus -> System.out.println(bus.routeNumber));
        System.out.println(fleet.calculateMinimumDrivers(70));
    }
}
