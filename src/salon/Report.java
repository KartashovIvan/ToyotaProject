package salon;

import car.Car;

import java.util.Arrays;

public class Report {
    private String managerName;
    private Car[] sellCars = new Car[0];

    public Report(String managerName) {
        this.managerName = managerName;
    }

    public Car[] getSellCars() {
        return sellCars;
    }

    public void addSellerCar(Car car){
        sellCars = Arrays.copyOf(sellCars, sellCars.length + 1);
        sellCars[sellCars.length - 1] = car;
    }
}
