class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }
}

class Car extends Vehicle {
    String model;

    Car(String brand, String model) {
        super(brand);
        this.model = model;
    }

    void display() {
        System.out.println(brand + " " + model);
    }
}

public class VehicleExte {
    public static void main(String[] args) {
        Car s = new Car("Toyota", "Supra");
        s.display();
    }
}