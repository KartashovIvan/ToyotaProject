package salon;

import car.Car;
import production.Conveyor;
import production.Stock;

public class Dealer {
    private Manager manager;
    private Car[] cars;

    public Dealer(Manager manager, Car[] cars) {
        this.manager = manager;
        this.cars = cars;
    }

    public Car waitBuyer(Buyer buyer) {
        return manager.sellCar(buyer, cars);
    }

    public Car getCarFromStock(Car soldCar, Stock stock, Conveyor conveyor) {
        String modelCar = soldCar.getClass().getSimpleName();
        if (modelCar.equals("Camry")) {
            Car car = stock.getCamry();
            if (car == null) {
                stock.addCamry(conveyor.createCamry(soldCar.getPrice(), soldCar.getColour()));
                car = stock.getCamry();
            }
            return car;
        } else if (modelCar.equals("Solara")) {
            Car car = stock.getSolara();
            if (car == null) {
                stock.addSolara(conveyor.createSolara(soldCar.getPrice(), soldCar.getColour()));
                car = stock.getSolara();
            }
            return car;
        } else if (modelCar.equals("Hiance")) {
            Car car = stock.getHiance();
            if (car == null) {
                stock.addHiance(conveyor.createHiance(soldCar.getPrice(), soldCar.getColour()));
                car = stock.getHiance();
            }
            return car;
        } else {
            Car car = stock.getDyna();
            if (car == null) {
                stock.addDyna(conveyor.createDyna(soldCar.getPrice(), soldCar.getColour()));
                car = stock.getDyna();
            }
            return car;
        }
    }

}
