package salon;

import car.Car;

public class Cashier {
    public static double profit = 0;

    public void addProfit(Car car) {
        profit += car.getPrice();
    }
}
