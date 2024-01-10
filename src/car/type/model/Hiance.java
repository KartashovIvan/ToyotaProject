package car.type.model;

import car.component.*;
import car.type.CargoVan;
import production.Country;

public class Hiance extends CargoVan {
    private Wheel spareWheel;

    public Hiance(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, double liftingCapacity, Country country, Wheel... wheels) {
        super(colour, maxSpeed, typeTransmission, gasTank, engine, electrics, headlight, liftingCapacity, country, wheels);
    }

    public Wheel getSpareWheel() {
        return spareWheel;
    }

    public void setSpareWheel(Wheel spareWheel) {
        this.spareWheel = spareWheel;
    }
}
