package com.app;

<<<<<<< HEAD
abstract class Vehicle {
=======
public abstract class Vehicle {
>>>>>>> 12a385a521493a3652251606f0821a392734a94f
    protected String fuelType;
    protected int maxSpeed;

    public Vehicle(String fuelType, int maxSpeed) {
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
    }

    public abstract String describe();

}

class ElectricCar extends Vehicle {

    public ElectricCar(String fuelType, int maxSpeed) {
        super(fuelType, maxSpeed);
    }

    @Override
    public String describe() {
        return "This electric car runs on " + fuelType + " and has a maximum speed of " + maxSpeed + " km/h.";
    }

}

class GasCar extends Vehicle {

    public GasCar(String fuelType, int maxSpeed) {
        super(fuelType, maxSpeed);
    }

    @Override
    public String describe() {
        return "This gas car runs on " + fuelType + " and has a maximum speed of " + maxSpeed + " km/h.";
    }

}

class Bicycle extends Vehicle {

    public Bicycle(String fuelType, int maxSpeed) {
        super(fuelType, maxSpeed);
    }

    @Override
    public String describe() {
        return "This bicycle runs on " + fuelType + " and has a maximum speed of " + maxSpeed + " km/h.";
    }
}
