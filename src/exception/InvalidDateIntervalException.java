package exception;

public class InvalidDateIntervalException extends Exception {

    public InvalidDateIntervalException(String message) {
        super(message);
    }

    public InvalidDateIntervalException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
