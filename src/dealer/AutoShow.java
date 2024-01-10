package dealer;

import car.type.Car;
import production.Conveyor;
import production.Stock;

public class AutoShow {
    private Manager manager;
    private Car[] cars;

    public AutoShow(Manager manager, Car[] cars) {
        this.manager = manager;
        this.cars = cars;
    }

    public Car waitBuyer(Buyer buyer) {
        return manager.sellCar(buyer, cars);
    }

    public Car getCarFromStock(Car soldCar, Stock stock, Conveyor conveyor) {
        String modelCar = soldCar.getClass().getSimpleName();
        if (modelCar.equals("Camry")) {
            return takeCamry(soldCar, stock, conveyor);
        } else if (modelCar.equals("Solara")) {
            return takeSolara(soldCar, stock, conveyor);
        } else if (modelCar.equals("Hiance")) {
            return takeHiance(soldCar, stock, conveyor);
        } else {
            return takeDyna(soldCar, stock, conveyor);
        }
    }

    private Car takeCamry(Car soldCar, Stock stock, Conveyor conveyor) {
        Car car = stock.getCamry();
        if (car == null) {
            stock.addCamry(conveyor.createCamry(soldCar.getPrice(), soldCar.getColour()));
            car = stock.getCamry();
        }
        return car;
    }

    private Car takeSolara(Car soldCar, Stock stock, Conveyor conveyor) {
        Car car = stock.getSolara();
        if (car == null) {
            stock.addSolara(conveyor.createSolara(soldCar.getPrice(), soldCar.getColour()));
            car = stock.getSolara();
        }
        return car;
    }

    private Car takeHiance(Car soldCar, Stock stock, Conveyor conveyor) {
        Car car = stock.getHiance();
        if (car == null) {
            stock.addHiance(conveyor.createHiance(soldCar.getPrice(), soldCar.getColour()));
            car = stock.getHiance();
        }
        return car;
    }

    private Car takeDyna(Car soldCar, Stock stock, Conveyor conveyor) {
        Car car = stock.getDyna();
        if (car == null) {
            stock.addDyna(conveyor.createDyna(soldCar.getPrice(), soldCar.getColour()));
            car = stock.getDyna();
        }
        return car;
    }

}
