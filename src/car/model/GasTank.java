package car.model;

public class GasTank {
    private final double volume;
    private double fuel = 0;

    public GasTank(double volume) {
        if (volume < 0) {
            throw new RuntimeException("Емкость бензобака не может быть отрицательным");
        }
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        if (this.fuel + fuel > this.volume) {
            throw new RuntimeException("Нельзя налить топлива больше " + volume);
        }
        this.fuel += fuel;
    }
}
