import car.Car;
import car.toyota.Camry;
import car.toyota.Dyna;
import car.toyota.Hiance;
import car.toyota.Solara;
import production.Conveyor;
import production.Country;
import production.Factory;
import production.Stock;
import salon.Buyer;
import salon.Cashier;
import salon.Dealer;
import salon.Manager;

public class Runner {
    public static void main(String[] args) {
        Factory factory = new Factory(Country.JAPAN);
        Conveyor conveyor = new Conveyor(Country.JAPAN, factory);
        Buyer[] buyers = {new Buyer("Jon", 10000)
                , new Buyer("Petr", 12000)
                , new Buyer("Ivan", 15000)
                , new Buyer("Nicola", 22000)
                , new Buyer("Katia", 11000)
                , new Buyer("Tony", 13000)
                , new Buyer("Vasya", 8000)
                , new Buyer("Yriy", 30000)};

        Camry camry = conveyor.createCamry(10000, "black");
        Solara solara = conveyor.createSolara(12000, "white");
        Hiance hiance = conveyor.createHiance(15000, "black");
        Dyna dyna = conveyor.createDyna(22000, "black");
        Car[] cars = {camry, solara, hiance, dyna};
        Manager manager = new Manager("Petr");
        Dealer dealer = new Dealer(manager, cars);
        Cashier cashier = new Cashier();

        Stock stock = new Stock();
        stock.addCamry(camry);
        stock.addSolara(solara);
        stock.addHiance(hiance);
        stock.addDyna(dyna);

        for (Buyer buyer : buyers) {
            Car soldCar = dealer.waitBuyer(buyer);
            if (soldCar == null) {
                System.out.println("Не достаточно денег!");
            } else {
                Car car = dealer.getCarFromStock(soldCar, stock, conveyor);
                cashier.addProfit(car);
            }
        }

        manager.generateReport();
    }
}
