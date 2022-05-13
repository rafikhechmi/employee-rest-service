package com.rafik.employeeservice.service;

import com.rafik.employeeservice.exception_handler.EmployeeNotFound;
import com.rafik.employeeservice.model.Employee;
import com.rafik.employeeservice.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import sun.awt.image.ImageWatched;

import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao service;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public EntityModel<Employee> getEmployeeById(@PathVariable int empId){
        Employee employee = service.getEmployeeById(empId);
        if(null == employee)
            throw new EmployeeNotFound("Employee Not Found .");
        EntityModel<Employee> model = EntityModel.of(employee);
        Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAll()).withRel("all-employees");
        model.add(link);

        return model;
    }
    @PostMapping("/employees/user")
    public ResponseEntity<Object> saveEmployee( @RequestBody Employee emp){
        Employee newEmployee = service.saveEmployee(emp);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{employeeId}")
                .buildAndExpand(newEmployee.getId())
                .toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/employees/delete/{empId}")
    public void deleteEmployee(@PathVariable int empId){
        Employee employee = service.deleteEmployee(empId);
        if(null == employee)
            throw new EmployeeNotFound("Employee Not Found .");
    }
}
