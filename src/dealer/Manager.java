package dealer;

import car.type.Car;
import java.io.FileWriter;
import java.io.IOException;

public class Manager {
    private final String name;
    private final Report report;

    public Manager(String name) {
        this.name = name;
        report = new Report(name);
    }

    public Car sellCar(Buyer buyer, Car... cars) {
        Car temp = null;
        for (Car car : cars) {
            temp = checkOutMoney(buyer.getMoney(), car, temp);
        }
        if (temp != null) {
            report.addSellerCar(temp);
        }
        return temp;
    }

    private Car checkOutMoney(double money, Car car, Car temp) {
        if (car.getPrice() <= money) {
            if (temp == null) {
                return car;
            } else {
                if (temp.getPrice() < car.getPrice()) {
                    return car;
                }
                return temp;
            }
        }
        return temp;
    }

    public void generateReport() {
        double expenses = 0;
        try (FileWriter fileWriter = new FileWriter("./resources/report/report.txt")) {
            fileWriter.write("Имя менеджера - " + this.name + "\n");
            for (Car car : report.getSellCars()) {
                String nameCar = car.getClass().getSimpleName();
                expenses += getCostPrice(nameCar);
                fileWriter.write("Модель - " + nameCar + " - стоимость продажи - " + car.getPrice() + " - себестоимость - " + getCostPrice(nameCar) + "\n");
            }
            fileWriter.write("Итог: доходы - " + Cashier.profit + ", расходы " + expenses + ", прибыль - " + (Cashier.profit - expenses));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private double getCostPrice(String name) {
        if (name.equalsIgnoreCase("Camry")) {
            return CarDirectory.CAMRY.getCostPrice();
        } else if (name.equalsIgnoreCase("Solara")) {
            return CarDirectory.SOLARA.getCostPrice();
        } else if (name.equalsIgnoreCase("Hiance")) {
            return CarDirectory.HIANCE.getCostPrice();
        } else {
            return CarDirectory.DYNA.getCostPrice();
        }
    }
}
