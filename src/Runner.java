import car.model.*;
import car.toyota.Camry;
import car.toyota.Dyna;
import car.toyota.Hiance;
import car.toyota.Solara;
import exeption.NoModelException;
import production.Conveyor;
import production.Country;
import production.Factory;
import production.Stock;

public class Runner {
    public static void main(String[] args) {
        Factory factory = new Factory(Country.GERMANY);
        Conveyor conveyor = new Conveyor(Country.GERMANY, factory);
        Wheel[] wheelsCamry = {new Wheel(17), new Wheel(17), new Wheel(17)};
        Wheel[] wheelsSolara = {new Wheel(16), new Wheel(16), new Wheel(16), new Wheel(16)};
        Wheel[] wheelsVan1 = {new Wheel(20), new Wheel(20), new Wheel(20), new Wheel(20)};
        Wheel[] wheelsVan2 = {new Wheel(20), new Wheel(20), new Wheel(20), new Wheel(20)};
        Camry camry = conveyor.createCamry(12000, "Черный");
        camry.fillGasTank(30);
        camry.addWheels(new Wheel(17));
        camry.startMoving();
        camry.stopMoving();
        Dyna dyna = conveyor.createDyna(22000, "Белый");
        dyna.fillGasTank(57);
        dyna.startMoving();
        Solara solara = conveyor.createSolara(13000, "Желтый");
        solara.fillGasTank(40);
        solara.startMoving();
        Hiance hiance = conveyor.createHiance(17000, "Белый");
        hiance.fillGasTank(67);
        hiance.startMoving();

        Camry camry2 = conveyor.createCamry(12000, "Черный");

        CarFunction[] carFunctions = {camry, solara, dyna};
        for (CarFunction cf : carFunctions) {
            cf.executeCarFunction();
        }

        Stock stock = new Stock();
//        stock.addCamry(camry);
        stock.addDyna(dyna);
        stock.addHiance(hiance);
        stock.addSolara(solara);
        try {
            stock.getCamry();
        } catch (NoModelException e) {
            System.out.println(e.getMessage());
        }
        stock.addCamry(camry2);
        stock.showQuantityCamry();
        stock.showQuantityDyna();
        stock.showQuantityHiance();
        stock.showQuantitySolara();
    }
}
