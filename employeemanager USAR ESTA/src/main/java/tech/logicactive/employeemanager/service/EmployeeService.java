package tech.logicactive.employeemanager.service;

import java.util.List;
import java.util.UUID;

import tech.logicactive.employeemanager.exception.UserNotFoundException;
import tech.logicactive.employeemanager.model.Employee;
import tech.logicactive.employeemanager.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
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
                .orElseThrow(() -> new UserNotFoundException("User by id: " + id + " not found."));
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

}
