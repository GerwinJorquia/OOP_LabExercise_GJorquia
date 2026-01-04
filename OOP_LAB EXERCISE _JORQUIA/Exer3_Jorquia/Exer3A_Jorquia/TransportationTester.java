public class TransportationTester {
    public static void main(String[] args) {

        Helicopter helicopter = new Helicopter();
        helicopter.move();
        helicopter.fly();

        Airplane airplane = new Airplane();
        airplane.move();
        airplane.fly();

        SpaceShuttle shuttle = new SpaceShuttle();
        shuttle.move();
        shuttle.fly();

       
        Truck truck = new Truck();
        truck.move();
        truck.drive();

        SUV suv = new SUV();
        suv.move();
        suv.drive();

        Tricycle tricycle = new Tricycle();
        tricycle.move();
        tricycle.drive();

        Motorcycle motorcycle = new Motorcycle();
        motorcycle.move();
        motorcycle.drive();

        Kariton kariton = new Kariton();
        kariton.move();
        kariton.drive();

        
        Boat boat = new Boat();
        boat.move();
        boat.sail();

        Canoe canoe = new Canoe();
        canoe.move();
        canoe.sail();
    }
}