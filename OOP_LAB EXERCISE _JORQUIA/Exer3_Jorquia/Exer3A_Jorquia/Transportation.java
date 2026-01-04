public class Transportation {
    protected String name;

    public Transportation(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println(name + " is moving.");
    }
}