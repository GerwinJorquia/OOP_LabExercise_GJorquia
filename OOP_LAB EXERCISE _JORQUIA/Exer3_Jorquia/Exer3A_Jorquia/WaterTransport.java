public class WaterTransport extends Transportation {
    public WaterTransport(String name) {
        super(name);
    }

    public void sail() {
        System.out.println(name + " is sailing.");
    }
}

class Boat extends WaterTransport {
    public Boat() {
        super("Boat");
    }
}

class Canoe extends WaterTransport {
    public Canoe() {
        super("Canoe");
    }
}