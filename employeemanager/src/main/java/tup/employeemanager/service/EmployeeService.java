package tup.employeemanager.service;

import java.util.List;
import java.util.UUID;

import tup.employeemanager.exception.UserNotFoundException;
import tup.employeemanager.model.Employee;
import tup.employeemanager.repository.EmployeeRepo;

import org.springframework.stereotype.Service;

/*
 * Documentación oficial
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/stereotype/Service.html
 * Indica que una clase anotada es un "Servicio", definido originalmente por 
 * Domain-Driven Design (Evans, 2003) como "una operación que se ofrece como 
 * una interfaz independiente en el modelo, sin estado encapsulado". También 
 * puede indicar que una clase es una "fachada de servicio comercial" (en el 
 * sentido de los patrones Core J2EE), o algo similar. Esta anotación es un 
 * estereotipo de propósito general y los equipos de desarrollo pueden reducir 
 * su semántica y usarla según corresponda. Esta anotación sirve como una 
 * especialización de @Component, lo que permite que las clases de implementación 
 * se detecten automáticamente a través del escaneo de classpath.
 * 
 * Este artículo de Baeldung
 * https://www.baeldung.com/spring-component-repository-service
 * explica las diferencias entre componente, repositorio
 * y servicio. 
 * Descripción general rápida de algunas de estas anotaciones:
 *    @Component es un estereotipo genérico para cualquier componente 
 *          administrado por Spring.
 *    @Service anota clases en la capa de servicio.
 *    @Repository anota las clases en la capa de persistencia, que 
 *          actuará como repositorio de la base de datos.
 * 
 * Esta clase, EmployeeService, invoca algunos métodos del campo
 * employeeRepo, que es de tipo EmployeeRepo. Pero EmployeeRepo
 * no es una clase, sino una interfaz. No implementa ningún método.
 * Solo extiende la interfaz JpaRepository, y por su parte expone
 * tres métodos.
 */
@Service
public class EmployeeService {

    /*
     * Para el patrón de inyección de dependencia.
     */
    private final EmployeeRepo employeeRepo;

    /*
     * Para el patrón de inyección de dependencia.
     */
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User id : " + id + " not found."));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

}
