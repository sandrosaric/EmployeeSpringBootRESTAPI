package com.sandrosaric.springbootbackend.controller;

import com.sandrosaric.springbootbackend.model.Employee;
import com.sandrosaric.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //build create employee REST api
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(this.employeeService.saveEmployee(employee), HttpStatus.CREATED );
    }

    //build get all employees REST api

    @GetMapping()
    public List<Employee> getEmployees(){
        return this.employeeService.getAllEmployees();
    }

    //build get employee by id REST api

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(name = "id") Long employeeId){
        return new ResponseEntity<Employee>(this.employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    //build update employee REST api

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") Long employeeId){
        return new ResponseEntity<Employee>(this.employeeService.updateEmployee(employee,employeeId),HttpStatus.OK);
    }


    //build delete employee REST api
    @DeleteMapping("{id")
    public ResponseEntity<String> deleteEmployee(@PathVariable(name="id") Long id){
        this.employeeService.deleteEmployee(id);
        return new ResponseEntity<String>("Resource has been successfully deleted!",HttpStatus.OK);
    }
}
