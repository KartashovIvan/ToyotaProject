package car.model;

public class Wheel {
    private boolean puncture;
    private final int diameter;

    public Wheel(int diameter) {
        if (diameter < 0) {
            throw new RuntimeException("Диаментр колеса не может быть отрицательным");
        }
        this.diameter = diameter;
    }

    public boolean isPuncture() {
        return puncture;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setPuncture(boolean puncture) {
        this.puncture = puncture;
    }
}
