package production;

import car.type.Car;
import car.type.model.Camry;
import car.type.model.Dyna;
import car.type.model.Hiance;
import car.type.model.Solara;
import exeption.StockOverflowException;
import java.util.Arrays;

public class Stock {
    private final int maxCapacity = 1000;
    private int countCar = 0;
    private Camry[] carsCamry = new Camry[0];
    private Solara[] carsSolara = new Solara[0];
    private Hiance[] carsHiance = new Hiance[0];
    private Dyna[] carsDyna = new Dyna[0];

    public void addCamry(Camry camry) {
        try {
            checkCapacity();
            carsCamry = Arrays.copyOf(carsCamry, carsCamry.length + 1);
            carsCamry[carsCamry.length - 1] = camry;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Camry getCamry() {
        if (checkModelCar(carsCamry) > 0) {
            Camry camry = carsCamry[carsCamry.length - 1];
            carsCamry = Arrays.copyOf(carsCamry, carsCamry.length - 1);
            countCar--;
            return camry;
        }
        return null;
    }

    public void showQuantityCamry() {
        System.out.println("Колличество Camry на складе " + carsCamry.length);
    }

    public void addSolara(Solara solara) {
        try {
            checkCapacity();
            carsSolara = Arrays.copyOf(carsSolara, carsSolara.length + 1);
            carsSolara[carsSolara.length - 1] = solara;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Solara getSolara() {
        if (checkModelCar(carsSolara) > 0) {
            Solara solara = carsSolara[carsSolara.length - 1];
            carsSolara = Arrays.copyOf(carsSolara, carsSolara.length - 1);
            countCar--;
            return solara;
        }
        return null;
    }

    public void showQuantitySolara() {
        System.out.println("Колличество Solara на складе " + carsSolara.length);
    }

    public void addHiance(Hiance hiance) {
        try {
            checkCapacity();
            carsHiance = Arrays.copyOf(carsHiance, carsHiance.length + 1);
            carsHiance[carsHiance.length - 1] = hiance;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Hiance getHiance() {
        if (checkModelCar(carsHiance) > 0) {
            Hiance hiance = carsHiance[carsHiance.length - 1];
            carsHiance = Arrays.copyOf(carsHiance, carsHiance.length - 1);
            countCar--;
            return hiance;
        }
        return null;
    }

    public void showQuantityHiance() {
        System.out.println("Колличество Hiance на складе " + carsHiance.length);
    }

    public void addDyna(Dyna dyna) {
        try {
            checkCapacity();
            carsDyna = Arrays.copyOf(carsDyna, carsDyna.length + 1);
            carsDyna[carsDyna.length - 1] = dyna;
            countCar++;
        } catch (StockOverflowException e) {
            System.out.println(e.getMessage());
        }
    }

    public Dyna getDyna() {
        if (checkModelCar(carsDyna) > 0) {
            Dyna dyna = carsDyna[carsDyna.length - 1];
            carsDyna = Arrays.copyOf(carsDyna, carsDyna.length - 1);
            countCar--;
            return dyna;
        }
        return null;
    }

    public void showQuantityDyna() {
        System.out.println("Колличество Dyna на складе " + carsDyna.length);
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
