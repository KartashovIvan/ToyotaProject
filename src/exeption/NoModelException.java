package exeption;

public class NoModelException extends Exception {
    public NoModelException(String model) {
        super("На складе нет модели " + model);
    }
}
