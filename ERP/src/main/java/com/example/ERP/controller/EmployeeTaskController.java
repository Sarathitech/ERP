package com.example.ERP.controller;

import com.example.ERP.model.EmployeeTask;
import com.example.ERP.service.EmployeeTaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee-tasks")
public class EmployeeTaskController {

    private final EmployeeTaskService employeeTaskService;

    public EmployeeTaskController(EmployeeTaskService employeeTaskService) {
        this.employeeTaskService = employeeTaskService;
    }
    @GetMapping("/getAll")
    public List<EmployeeTask> getAll()
    {
        return employeeTaskService.getAllStudent();
    }

    @PostMapping("/emp")
    public ResponseEntity<EmployeeTask> createEmployeeTask(@RequestBody EmployeeTask employeeTask) {
        EmployeeTask createdEmployeeTask = employeeTaskService.createEmployeeTask(employeeTask);
        return ResponseEntity.ok(createdEmployeeTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeTask> getEmployeeTaskById(@PathVariable(value = "id") Long id) {
        EmployeeTask employeeTask = employeeTaskService.getEmployeeTaskById(id);
        return ResponseEntity.ok(employeeTask);
    }

    @PutMapping("/{id}")
    public String updateEmployeeTask(@PathVariable(value = "id") Long id, @RequestBody EmployeeTask employeeTask) {
        EmployeeTask updatedEmployeeTask = employeeTaskService.updateEmployeeTask(id, employeeTask);
       ResponseEntity.ok(updatedEmployeeTask);
        return "update success";
    }


    @DeleteMapping("/{id}")
    public String deleteEmployeeTask(@PathVariable(value = "id") Long id) {
        employeeTaskService.deleteEmployeeTask(id);
         ResponseEntity.ok().build();
        return "deleted successfully ";
    }
}
