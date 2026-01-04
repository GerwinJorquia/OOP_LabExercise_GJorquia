class Vehicle {
    String brand;
    String color;
    String plateNo;
    String chassisNo;
    String engineType;

    public Vehicle(String brand, String color, String plateNo, String chassisNo, String engineType) {
        this.brand = brand;
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
        this.engineType = engineType;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Color: " + color);
        System.out.println("Plate No: " + plateNo);
        System.out.println("Chassis No: " + chassisNo);
        System.out.println("Engine Type: " + engineType);
        System.out.println(); 
    }
}
class VehicleInfo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Vehicle("Ford", "Yellow", "ABC-153", "XM-702", "Diesel"),
            new Vehicle("Mercedes", "Black", "A-270", "XT-780", "Gasoline"),
            new Vehicle("Toyota", "Black", "ABC-122", "XYZ-789", "Gasoline"),
            new Vehicle("Ferrari", "Black", "CDA-143", "FT-275", "Gasoline"),
            new Vehicle("Honda", "Grey", "AT-204", "YX-750", "Diesel"),
            new Vehicle("Maserati", "White", "GTX-458", "JXT-709", "Gasoline"),
            new Vehicle("Nissan", "Green", "BA-304", "XM-75", "Gasoline"),
            new Vehicle("Subaru", "Red", "AK-334", "XM-570", "Gasoline"),
            new Vehicle("Kia", "Brown", "AC-147", "XT-341", "Diesel"),
            new Vehicle("Mazda", "Black", "ATV-457", "VX-53", "Diesel")
        };

        for (Vehicle v : vehicles) {
            v.displayInfo();
        }
    }
}