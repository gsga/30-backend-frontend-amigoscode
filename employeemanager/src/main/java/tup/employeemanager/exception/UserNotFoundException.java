package tup.employeemanager.exception;

/*
IllegalArgumentException es lanzada por EmployeeRepo.findEmployeeById().
*/

public class UserNotFoundException extends IllegalArgumentException {
    public UserNotFoundException(String message) {
        super(message);
    }

}
