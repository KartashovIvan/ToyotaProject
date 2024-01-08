package car.toyota;

import car.PassengerCar;
import car.model.*;
import production.Country;

public class Camry extends PassengerCar implements CarFunction {
    private final Usb usb = new Usb();

    public Camry(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, Country country, Wheel... wheels) {
        super(colour, maxSpeed, typeTransmission, gasTank, engine, electrics, headlight, country, wheels);
    }

    @Override
    public void executeCarFunction() {
        usb.connect("Музыка");
    }
}
