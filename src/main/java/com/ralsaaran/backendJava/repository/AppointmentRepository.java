package com.ralsaaran.backendJava.repository;

import com.ralsaaran.backendJava.model.entities.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepository extends
        JpaRepository<Appointments, Long>,
        JpaSpecificationExecutor<Appointments>

{
    List<Appointments> findByIdNumber(String idNumber);
}
