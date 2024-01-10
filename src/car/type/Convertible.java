package car.type;

import car.component.*;
import production.Country;

public abstract class Convertible extends PassengerCar {
    private final Roof roof = new Roof();

    public Convertible(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, Country country, Wheel... wheels) {
        super(colour, maxSpeed, typeTransmission, gasTank, engine, electrics, headlight, country, wheels);
    }

    public Roof getRoof() {
        return roof;
    }

    public void catchUpRoof() {
        roof.setRaise(true);
    }

    public void putDownRoof() {
        roof.setRaise(false);
    }
}
