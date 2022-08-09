package tup.employeemanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tup.employeemanager.model.Employee;

/*
 * Documentación oficial
 * https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html
 * 
 * Este artículo de GeeksforGeeks
 * https://www.geeksforgeeks.org/spring-boot-jparepository-with-example/
 * explica que JpaRepository es una extensión de Repository específica 
 * para JPA (API de persistencia de Java). Contiene la API completa 
 * de CrudRepository y PagingAndSortingRepository. Por lo tanto, contiene 
 * la API para operaciones CRUD básicas y también la API para paginación 
 * y clasificación.
 * Tiene muchos métodos, con los nombres lógicos para las funcionalidades
 * que promete.
 * 
 * Esta es una interfaz, no una clase. Está pensada para la inyección de
 * dependencia.
 * Publica algunos métodos, pero no implementa nada. 
 * Como extiende la interfaz JpaRepository, expone todos los métodos
 * de esa interfaz. Así que, aunque no los hayamos declarado
 * nosotros explícitamente acá, los podemos usar. No hay que
 * implementarlos. Para usarlos hay que inyectar la dependencia
 * y anotar la clase que presta los servicios con @Service.
 */
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    /*
     * La interfaz JpaRepository tiene un método getById(ID id),
     * pero está deprecado. La documentación sugiere usar
     * getReferenceById(ID). Pero este método retorna una referencia
     * a la entidad, no la entidad. No me gusta mucho, y no es muy usada.
     * Por otro lado, esta interfaz hereda de CrudRepository el método
     * findById:
     * https://docs.spring.io/spring-data/commons/docs/current/api/org/
     * springframework/data/repository/CrudRepository.html?is-external=true#findById
     * -ID-
     * 
     * que tiene la firma
     * Optional<T> findById(ID id)
     * La documentación dice que recupera una entidad por su ID.
     * Parámetros: id - no debe ser nulo.
     * Devuelve: la entidad con la identificación dada o bien
     * Opcional#empty() si no se encuentra ninguno.
     * Lanza: IllegalArgumentException - si id es nulo.
     */
    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findAll();

}
