package production;

import car.Car;
import car.toyota.Camry;
import car.toyota.Dyna;
import car.toyota.Hiance;
import car.toyota.Solara;
import exeption.NoModelException;
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
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Camry getCamry() throws NoModelException {
        if (checkModelCar(CarsCamry)) {
            Camry camry = CarsCamry[CarsCamry.length - 1];
            CarsCamry = Arrays.copyOf(CarsCamry, CarsCamry.length - 1);
            countCar--;
            return camry;
        } else {
            throw new NoModelException("Camry");
        }
    }

    public void showQuantityCamry() {
        System.out.println("Колличество Camry на складе " + CarsCamry.length);
    }

    public void addSolara(Solara solara) {
        try {
            checkCapacity();
            CarsSolara = Arrays.copyOf(CarsSolara, CarsSolara.length + 1);
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Solara getSolara() throws NoModelException {
        if (checkModelCar(CarsCamry)) {
            Solara solara = CarsSolara[CarsSolara.length - 1];
            CarsSolara = Arrays.copyOf(CarsSolara, CarsSolara.length - 1);
            countCar--;
            return solara;
        } else {
            throw new NoModelException("Solara");
        }
    }

    public void showQuantitySolara() {
        System.out.println("Колличество Solara на складе " + CarsSolara.length);
    }

    public void addHiance(Hiance hiance) {
        try {
            checkCapacity();
            CarsHiance = Arrays.copyOf(CarsHiance, CarsHiance.length + 1);
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Hiance getHiance() throws NoModelException {
        if (checkModelCar(CarsCamry)) {
            Hiance hiance = CarsHiance[CarsHiance.length - 1];
            CarsHiance = Arrays.copyOf(CarsHiance, CarsHiance.length - 1);
            countCar--;
            return hiance;
        } else {
            throw new NoModelException("Hiance");
        }
    }

    public void showQuantityHiance() {
        System.out.println("Колличество Hiance на складе " + CarsHiance.length);
    }

    public void addDyna(Dyna dyna) {
        try {
            checkCapacity();
            CarsDyna = Arrays.copyOf(CarsDyna, CarsDyna.length + 1);
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Dyna getDyna() throws NoModelException {
        if (checkModelCar(CarsCamry)) {
            Dyna dyna = CarsDyna[CarsDyna.length - 1];
            CarsDyna = Arrays.copyOf(CarsDyna, CarsDyna.length - 1);
            countCar--;
            return dyna;
        } else {
            throw new NoModelException("Dyna");
        }
    }

    public void showQuantityDyna() {
        System.out.println("Колличество Dyna на складе " + CarsDyna.length);
    }

    private void checkCapacity() throws StockOverflowException {
        if (countCar == maxCapacity) {
            throw new StockOverflowException();
        }
    }

    private boolean checkModelCar(Car[] cars) {
        return cars.length != 0;
    }
}
