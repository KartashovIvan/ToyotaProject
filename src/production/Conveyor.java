package production;

import car.model.*;
import car.toyota.Camry;
import car.toyota.Dyna;
import car.toyota.Hiance;
import car.toyota.Solara;
import exeption.CountyFactoryNotEqualException;

public class Conveyor {
    Country country;
    Factory factory;

    public Conveyor(Country country, Factory factory) {
        this.country = country;
        try {
            checkCountry(factory);
        } catch (CountyFactoryNotEqualException e) {
            System.out.println(e.getMessage());
        }
        this.factory = factory;
    }

    private void checkCountry(Factory factory) throws CountyFactoryNotEqualException {
        if (factory.getCountry() != country) {
            throw new CountyFactoryNotEqualException("Фабрика находится в " + factory.getCountry() + ", а сборочный конвеер в " + country);
        }
    }

    public Camry createCamry(double price, String colour) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = factory.createWheel(17);
        }
        GasTank gasTank = factory.createGasTank(50);
        Engine engine = factory.createEngine();
        Electrics electrics = factory.createElectrics();
        Headlight headlight = factory.createHeadlight();
        Camry camry = new Camry(colour, 250, TypeTransmission.AUTOMATIC, gasTank, engine, electrics, headlight, country, wheels);
        camry.setPrice(price);
        return camry;
    }

    public Solara createSolara(double price, String colour) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = factory.createWheel(16);
        }
        GasTank gasTank = factory.createGasTank(45);
        Engine engine = factory.createEngine();
        Electrics electrics = factory.createElectrics();
        Headlight headlight = factory.createHeadlight();
        Solara solara = new Solara(colour, 350, TypeTransmission.ROBOTIC, gasTank, engine, electrics, headlight, country, wheels);
        solara.setPrice(price);
        return solara;
    }

    public Hiance createHiance(double price, String colour) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = factory.createWheel(20);
        }
        GasTank gasTank = factory.createGasTank(75);
        Engine engine = factory.createEngine();
        Electrics electrics = factory.createElectrics();
        Headlight headlight = factory.createHeadlight();
        Hiance hiance = new Hiance(colour, 200, TypeTransmission.MANUAL, gasTank, engine, electrics, headlight, 2500, country, wheels);
        hiance.setPrice(price);
        hiance.setSpareWheel(factory.createWheel(20));
        return hiance;
    }

    public Dyna createDyna(double price, String colour) {
        Wheel[] wheels = new Wheel[4];
        for (int i = 0; i < 4; i++) {
            wheels[i] = factory.createWheel(20);
        }
        GasTank gasTank = factory.createGasTank(80);
        Engine engine = factory.createEngine();
        Electrics electrics = factory.createElectrics();
        Headlight headlight = factory.createHeadlight();
        Dyna dyna = new Dyna(colour, 180, TypeTransmission.MANUAL, gasTank, engine, electrics, headlight, 4000, country, wheels);
        dyna.setPrice(price);
        return dyna;
    }
}
