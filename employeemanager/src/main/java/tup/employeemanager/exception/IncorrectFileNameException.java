package tup.employeemanager.exception;

public class IncorrectFileNameException extends Exception {
    public IncorrectFileNameException(String errorMessage) {
        super(errorMessage);
    }

    public IncorrectFileNameException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}