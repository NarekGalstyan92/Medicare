package com.medicare.medicare.repository;

import com.medicare.medicare.entity.MedService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedServiceRepository extends JpaRepository<MedService, Integer> {
    List<MedService> findById(int id);
}
