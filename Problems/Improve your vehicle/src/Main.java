class Vehicle {

    private String name;

    public Vehicle(String name) {
        this.name = name;
    }


    class Engine {

        int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        void printHorsePower() {
            System.out.printf("\nVehicle %s has %d horsepower.", name, horsePower);
        }

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Engine engine = vehicle.new Engine(15);
        engine.printHorsePower();
    }
}