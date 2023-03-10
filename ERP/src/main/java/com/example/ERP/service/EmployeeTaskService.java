package com.example.ERP.service;

import com.example.ERP.Repository.EmployeeTaskRepository;
import com.example.ERP.model.EmployeeTask;
import com.example.ERP.Repository.EmployeeTaskRepository;
import com.example.ERP.model.EmployeeTask;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeTaskService {

    private final EmployeeTaskRepository employeeTaskRepository;

    public EmployeeTaskService(EmployeeTaskRepository employeeTaskRepository) {
        this.employeeTaskRepository = employeeTaskRepository;
    }

    public EmployeeTask createEmployeeTask(EmployeeTask employeeTask) {
        String a = employeeTask.getToken();
        LocalDateTime now = LocalDateTime.now();
        UUID uuid = UUID.randomUUID();
        if (now.isAfter(employeeTask.getDeadline())) {

            employeeTask.setToken(uuid.toString());
        } else {
            employeeTask.setToken(null);
        }
        return employeeTaskRepository.save(employeeTask);
    }

    public EmployeeTask getEmployeeTaskById(Long id) {
        return employeeTaskRepository.findById(id).orElseThrow(() -> new RuntimeException("EmployeeTask not found with id: " + id));
    }


    public EmployeeTask updateEmployeeTask(Long id, EmployeeTask employeeTask) {
        EmployeeTask existingEmployeeTask = employeeTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeTask not found with id: " + id));
        existingEmployeeTask.setTitle(employeeTask.getTitle());
        existingEmployeeTask.setDescription(employeeTask.getDescription());
        existingEmployeeTask.setDeadline(employeeTask.getDeadline());
        existingEmployeeTask.setToken(employeeTask.getToken());
        return employeeTaskRepository.save(existingEmployeeTask);
    }

    public void deleteEmployeeTask(Long id) {
        EmployeeTask employeeTask = employeeTaskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EmployeeTask not found with id: " + id));
        employeeTaskRepository.delete(employeeTask);
    }

    public List<EmployeeTask> getAllStudent() {

            return employeeTaskRepository.findAll();

    }
}
