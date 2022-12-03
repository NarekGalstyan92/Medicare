package com.medicare.medicare.repository;

import com.medicare.medicare.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    Optional<Appointment> findById(Integer integer);
}
