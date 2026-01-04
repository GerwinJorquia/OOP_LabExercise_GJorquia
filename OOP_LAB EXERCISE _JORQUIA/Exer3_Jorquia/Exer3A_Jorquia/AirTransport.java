public class AirTransport extends Transportation {
    public AirTransport(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(name + " is flying.");
    }
}

class Helicopter extends AirTransport {
    public Helicopter() {
        super("Helicopter");
    }
}

class Airplane extends AirTransport {
    public Airplane() {
        super("Airplane");
    }
}

class SpaceShuttle extends AirTransport {
    public SpaceShuttle() {
        super("Space Shuttle");
    }
}