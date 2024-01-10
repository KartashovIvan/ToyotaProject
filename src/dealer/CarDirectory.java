package dealer;

public enum CarDirectory {
    CAMRY("Camry", 5000),
    SOLARA("Solara", 8000),
    HIANCE("Hiance", 10000),
    DYNA("Dyna", 12000);
    private String carName;
    private double costPrice;

    CarDirectory(String carName, double price) {
        this.carName = carName;
        this.costPrice = price;
    }

    public String getCarName() {
        return carName;
    }

    public double getCostPrice() {
        return costPrice;
    }
}
