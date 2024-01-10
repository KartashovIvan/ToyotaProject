package production;

import car.component.*;

public class Factory {
    private final Country country;

    public Factory(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public Wheel createWheel(int diameter) {
        return new Wheel(diameter);
    }

    public GasTank createGasTank(int volume) {
        return new GasTank(volume);
    }

    public Engine createEngine() {
        return new Engine();
    }

    public Electrics createElectrics() {
        return new Electrics();
    }

    public Headlight createHeadlight() {
        return new Headlight();
    }
}
