package tech.logicactive.employeemanager.exception;

/*
Esta excepción debería extender Exception (checked), y no RunTimeException(unchecked).
Hay controversia sobre este punto. Java lo aconseja de este modo. Otros lenguajes lo
resuelven cada uno a su manera.
*/

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

}
