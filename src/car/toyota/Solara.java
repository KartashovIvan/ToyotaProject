package car.toyota;

import car.Convertible;
import car.model.*;
import production.Country;

public class Solara extends Convertible implements CarFunction {
    MiniFridge miniFridge = new MiniFridge();

    public Solara(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, Country country, Wheel... wheels) {
        super(colour, maxSpeed, typeTransmission, gasTank, engine, electrics, headlight, country, wheels);
    }

    @Override
    public void executeCarFunction() {
        miniFridge.cool("Напиток");
    }
}
