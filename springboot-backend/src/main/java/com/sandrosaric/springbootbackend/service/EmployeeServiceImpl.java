package com.sandrosaric.springbootbackend.service;

import com.sandrosaric.springbootbackend.exception.ResourceNotFoundException;
import com.sandrosaric.springbootbackend.model.Employee;
import com.sandrosaric.springbootbackend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {

        return this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee,Long id) {
        //checking if employee with given id exists

        Employee existingEmployee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName((employee.getLastName()));
        existingEmployee.setEmail(employee.getEmail());

        //save existing employee to db

        this.employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(Long id) {
        //checking if employee exists

        Employee existingEmployee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);

    }


}
