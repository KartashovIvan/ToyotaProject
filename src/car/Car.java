package car;

import car.model.*;
import exeption.StartCarException;
import production.Country;

public abstract class Car {
    private final int countWheels = 4;
    private String colour;
    private final int maxSpeed;
    private final TypeTransmission typeTransmission;
    private boolean inMove;
    private GasTank gasTank;
    private Engine engine;
    private Electrics electrics;
    private Headlight headlight;
    private double price;
    private final Wheel[] wheels = new Wheel[countWheels];
    private final Country country;

    public Car(String colour, int maxSpeed, TypeTransmission typeTransmission, GasTank gasTank, Engine engine, Electrics electrics, Headlight headlight, Country country, Wheel... wheels) {
        this.colour = colour;
        this.maxSpeed = maxSpeed;
        this.typeTransmission = typeTransmission;
        this.gasTank = gasTank;
        this.engine = engine;
        this.electrics = electrics;
        this.headlight = headlight;
        this.country = country;
        addWheels(wheels);
    }

    public String getColour() {
        return colour;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public TypeTransmission getTypeTransmission() {
        return typeTransmission;
    }

    public boolean isInMove() {
        return inMove;
    }

    public Wheel[] getWheels() {
        return wheels;
    }

    public GasTank getGasTank() {
        return gasTank;
    }

    public Engine getEngine() {
        return engine;
    }

    public Electrics getElectrics() {
        return electrics;
    }

    public Headlight getHeadlight() {
        return headlight;
    }

    public double getPrice() {
        return price;
    }

    public Country getCountry() {
        return country;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setInMove(boolean inMove) {
        this.inMove = inMove;
    }

    public void setGasTank(GasTank gasTank) {
        this.gasTank = gasTank;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setElectrics(Electrics electrics) {
        this.electrics = electrics;
    }

    public void setHeadlight(Headlight headlight) {
        this.headlight = headlight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addWheels(Wheel... wheels) {
        int y = 0;
        Wheel[] wheels1 = getWheels();
        for (int i = 0; i < wheels1.length; i++) {
            if (wheels1[i] == null || wheels1[i].isPuncture()) {
                if (y < wheels.length) {
                    wheels1[i] = wheels[y++];
                }
            }
        }
    }

    public void fillGasTank(int fuel) {
        gasTank.setFuel(fuel);
    }

    public void startMoving() {
        try {
            checkWheel();
            checkGasTank();
            checkElectrics();
            checkEngine();
        } catch (StartCarException e) {
            System.out.println(e.getMessage());
        }
        inMove = true;
    }

    private void checkWheel() throws StartCarException {
        for (int i = 0; i < countWheels; i++) {
            if (wheels[i] == null) {
                throw new StartCarException("Отсутствует колесо " + (i + 1));
            }
            if (wheels[i].isPuncture()) {
                throw new StartCarException("Проколото колесо " + (i + 1));
            }
        }
    }

    private void checkGasTank() throws StartCarException {
        if (gasTank.getFuel() == 0) {
            throw new StartCarException("Пустой бензобак");
        }
    }

    private void checkElectrics() throws StartCarException {
        if (electrics.isDefective()) {
            throw new StartCarException("Проблемы с электрикой");
        }
    }

    private void checkEngine() throws StartCarException {
        if (engine.isDefective()) {
            throw new StartCarException("Проблемы с двигателем");
        }
    }

    public void stopMoving() {
        inMove = false;
    }

    public void lightOn() {
        System.out.println("Фары включены");
    }
}
