package tup.employeemanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tup.employeemanager.model.Employee;
import tup.employeemanager.service.EmployeeService;

/*
 * Documentación oficial:
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html
 * 
 * Una anotación de conveniencia que a su vez está anotada
 * con @Controller y @ResponseBody. Los tipos que llevan esta 
 * anotación se tratan como controladores donde los 
 * métodos @RequestMapping asumen la semántica @ResponseBody 
 * de manera predeterminada.
 * 
 * El siguiente tutorial de GeeksforGeeks
 * https://www.geeksforgeeks.org/spring-rest-controller/
 * explica qué es y cómo se usa, paso a paso.
 */
@RestController
/*
 * Esta es la manera de habilitar el CORS para toda la clase.
 * Hay un modo más complicado, con un bean. Por ahora, este
 * es el modo que prefiero.
 */
// @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeController {

    /*
     * Documentación oficial:
     * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/
     * springframework/beans/factory/annotation/Autowired.html
     * 
     * Marca un constructor, un campo, un setter o un método de
     * configuración para que sea conectado automáticamente por
     * las facilidades de inyección de dependencias de Spring.
     * 
     * 
     * El siguiente tutorial de Baeldung
     * https://www.baeldung.com/spring-autowire
     * explica qué es y cómo se usa, paso a paso. Como todo lo de Baeldung,
     * es exhaustivo. Pero vale la pena.
     * 
     * Esta anotación es una parte de la inyección de dependencia.
     * Nosotros queremos inyectar en esta clase, EmployeeController,
     * la dependencia de la clase EmployeeService. Para eso, vamos
     * a tener un campo llamado employeeService, de tipo EmployeeService.
     * La inyección se completa con el constructor especializado.
     */
    @Autowired
    private final EmployeeService employeeService;

    /*
     * Documentación oficial
     * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using.
     * spring-beans-and-dependency-injection
     * 
     * Artículo en un blog oficial (MUY INTERESANTE DISCUSIÓN)
     * https://spring.io/blog/2007/07/11/setter-injection-versus-constructor-
     * injection-and-the-use-of-required/
     * 
     * Tutorial de Baeldung
     * https://www.baeldung.com/constructor-injection-in-spring
     * Muy interesante, vale la pena leerlo.
     * 
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee empl) {
        Employee employee = employeeService.addEmployee(empl);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee empl) {
        Employee employee = employeeService.updateEmployee(empl);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
