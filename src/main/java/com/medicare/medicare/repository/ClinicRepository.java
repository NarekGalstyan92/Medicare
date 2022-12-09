package com.medicare.medicare.repository;

import com.medicare.medicare.entity.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    List<Clinic> findById(int id);

    @Query(value = "select working_days, open_time, close_time from medicare.med_clinic", nativeQuery = true)
    Clinic findWorkingDateTime();

}
