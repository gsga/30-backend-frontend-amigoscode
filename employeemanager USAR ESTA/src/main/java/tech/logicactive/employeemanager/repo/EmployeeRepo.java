package tech.logicactive.employeemanager.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.logicactive.employeemanager.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
    List<Employee> findAll();

}
