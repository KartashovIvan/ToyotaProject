package car.type;

import car.component.*;
import production.Country;

public abstract class PassengerCar extends Car {
    private final CruiseControl cruiseControl = new CruiseControl();

    public PassengerCar(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, Country country, Wheel... wheels) {
        super(colour, maxSpeed, typeTransmission, gasTank, engine, electrics, headlight, country, wheels);
    }

    public CruiseControl getCruiseControl() {
        return cruiseControl;
    }

    public void onCruiseControl() {
        cruiseControl.setWork(true);
    }

    public void offCruiseControl() {
        cruiseControl.setWork(false);
    }
}
