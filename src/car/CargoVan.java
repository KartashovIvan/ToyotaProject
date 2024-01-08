package car;

import car.model.*;
import production.Country;

public abstract class CargoVan extends Car {
    private final double liftingCapacity;

    public CargoVan(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, double liftingCapacity, Country country, Wheel... wheels) {
        super(colour, maxSpeed, typeTransmission, gasTank, engine, electrics, headlight, country, wheels);
        this.liftingCapacity = liftingCapacity;
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }
}
