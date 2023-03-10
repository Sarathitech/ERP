package com.example.ERP.Repository;

import com.example.ERP.model.EmployeeTask;
import com.example.ERP.model.EmployeeTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmployeeTaskRepository extends JpaRepository<EmployeeTask, Long> {
}
