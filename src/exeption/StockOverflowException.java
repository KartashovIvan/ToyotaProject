package exeption;

public class StockOverflowException extends Exception {
    public StockOverflowException() {
        super("Склад переполнен");
    }
}
