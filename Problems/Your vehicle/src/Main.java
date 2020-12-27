class EnjoyVehicle {

    public static void startVehicle() {
        Vehicle vehicle = new Vehicle();
        Vehicle.Engine engine = vehicle.new Engine();
        engine.start();
    }
}