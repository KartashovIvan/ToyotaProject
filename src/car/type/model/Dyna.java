package car.type.model;

import car.component.*;
import car.type.CargoVan;
import production.Country;

public class Dyna extends CargoVan implements CarFunction {
    PowerOutlet powerOutlet = new PowerOutlet();

    public Dyna(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, double liftingCapacity, Country country, Wheel... wheels) {
        super(colour, maxSpeed, typeTransmission, gasTank, engine, electrics, headlight, liftingCapacity, country, wheels);
    }

    @Override
    public void executeCarFunction() {
        powerOutlet.charge("Телефон");
    }
}
