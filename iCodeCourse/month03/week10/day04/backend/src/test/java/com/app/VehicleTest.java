package com.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void testElectricCar() {
        ElectricCar tesla = new ElectricCar("120V", 322);
        assertTrue(tesla.describe().contains("This electric car runs on 120V and has a maximum speed of 322 km/h."));
        ElectricCar bmw = new ElectricCar("120V", 190);
        assertTrue(bmw.describe().contains("This electric car runs on 120V and has a maximum speed of 190 km/h."));
    }

    @Test
    void testGasCar() {
        GasCar ford = new GasCar("Gasoline", 250);
        assertTrue(ford.describe().contains("This gas car runs on Gasoline and has a maximum speed of 250 km/h."));
        GasCar toyota = new GasCar("Gasoline", 180);
        assertTrue(toyota.describe().contains("This gas car runs on Gasoline and has a maximum speed of 180 km/h."));
    }

    @Test
    void testBicycle() {
        Bicycle mountainBike = new Bicycle("Human Power", 30);
        assertTrue(mountainBike.describe()
                .contains("This bicycle runs on Human Power and has a maximum speed of 30 km/h."));
        Bicycle roadBike = new Bicycle("Human Power", 40);
        assertTrue(
                roadBike.describe().contains("This bicycle runs on Human Power and has a maximum speed of 40 km/h."));
    }

    @Test
    void testPolymorphism() {
        Vehicle[] vehicles = {
                new Bicycle("Human Power", 30),
                new ElectricCar("240V", 322),
                new ElectricCar("120V", 190),
                new GasCar("Gasoline", 250),
                new GasCar("Gasoline", 180),
                new Bicycle("Human Power", 30)
        };
        for (Vehicle v : vehicles) {
            String description = v.describe();
            assertNotNull(description);
            assertFalse(description.isEmpty());
        }
    }

}