public class LandTransport extends Transportation {
    public LandTransport(String name) {
        super(name);
    }

    public void drive() {
        System.out.println(name + " is driving.");
    }
}

class Truck extends LandTransport {
    public Truck() {
        super("Truck");
    }
}

class SUV extends LandTransport {
    public SUV() {
        super("SUV");
    }
}

class Tricycle extends LandTransport {
    public Tricycle() {
        super("Tricycle");
    }
}

class Motorcycle extends LandTransport {
    public Motorcycle() {
        super("Motorcycle");
    }
}

class Kariton extends LandTransport {
    public Kariton() {
        super("Kariton");
    }
}