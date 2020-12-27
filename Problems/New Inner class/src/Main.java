class Vehicle {

    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    class Engine {

        void start() {
            System.out.println("RRRrrrrrrr....");
        }

    }

    class Body {
        private String color;

        public Body(String color) {
            this.color = color;
        }

        void printColor() {
            System.out.printf("\nVehicle " + name + " has " + color + " body.");
        }
    }
}

// this code should work
class EnjoyVehicle {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Dixi");
        Vehicle.Body body = vehicle.new Body("red");
        body.printColor();
    }
}