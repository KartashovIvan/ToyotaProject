package production;

import car.Car;
import car.toyota.Camry;
import car.toyota.Dyna;
import car.toyota.Hiance;
import car.toyota.Solara;
import exeption.StockOverflowException;

import java.util.Arrays;

public class Stock {
    private final int maxCapacity = 1000;
    private int countCar = 0;
    private Camry[] CarsCamry = new Camry[0];
    private Solara[] CarsSolara = new Solara[0];
    private Hiance[] CarsHiance = new Hiance[0];
    private Dyna[] CarsDyna = new Dyna[0];

    public void addCamry(Camry camry) {
        try {
            checkCapacity();
            CarsCamry = Arrays.copyOf(CarsCamry, CarsCamry.length + 1);
            CarsCamry[CarsCamry.length - 1] = camry;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Camry getCamry() {
        if (checkModelCar(CarsCamry) > 0) {
            Camry camry = CarsCamry[CarsCamry.length - 1];
            CarsCamry = Arrays.copyOf(CarsCamry, CarsCamry.length - 1);
            countCar--;
            return camry;
        }
        return null;
    }

    public void showQuantityCamry() {
        System.out.println("Колличество Camry на складе " + CarsCamry.length);
    }

    public void addSolara(Solara solara) {
        try {
            checkCapacity();
            CarsSolara = Arrays.copyOf(CarsSolara, CarsSolara.length + 1);
            CarsSolara[CarsSolara.length - 1] = solara;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Solara getSolara() {
        if (checkModelCar(CarsSolara) > 0) {
            Solara solara = CarsSolara[CarsSolara.length - 1];
            CarsSolara = Arrays.copyOf(CarsSolara, CarsSolara.length - 1);
            countCar--;
            return solara;
        }
        return null;
    }

    public void showQuantitySolara() {
        System.out.println("Колличество Solara на складе " + CarsSolara.length);
    }

    public void addHiance(Hiance hiance) {
        try {
            checkCapacity();
            CarsHiance = Arrays.copyOf(CarsHiance, CarsHiance.length + 1);
            CarsHiance[CarsHiance.length - 1] = hiance;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Hiance getHiance() {
        if (checkModelCar(CarsHiance) > 0) {
            Hiance hiance = CarsHiance[CarsHiance.length - 1];
            CarsHiance = Arrays.copyOf(CarsHiance, CarsHiance.length - 1);
            countCar--;
            return hiance;
        }
        return null;
    }

    public void showQuantityHiance() {
        System.out.println("Колличество Hiance на складе " + CarsHiance.length);
    }

    public void addDyna(Dyna dyna) {
        try {
            checkCapacity();
            CarsDyna = Arrays.copyOf(CarsDyna, CarsDyna.length + 1);
            CarsDyna[CarsDyna.length - 1] = dyna;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Dyna getDyna() {
        if (checkModelCar(CarsDyna) > 0) {
            Dyna dyna = CarsDyna[CarsDyna.length - 1];
            CarsDyna = Arrays.copyOf(CarsDyna, CarsDyna.length - 1);
            countCar--;
            return dyna;
        }
        return null;
    }

    public void showQuantityDyna() {
        System.out.println("Колличество Dyna на складе " + CarsDyna.length);
    }

    private void checkCapacity() throws StockOverflowException {
        if (countCar == maxCapacity) {
            throw new StockOverflowException();
        }
    }

    private int checkModelCar(Car[] cars) {
        return cars.length;
    }
}
