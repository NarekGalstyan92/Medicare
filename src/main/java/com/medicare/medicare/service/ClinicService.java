package com.medicare.medicare.service;

import com.medicare.medicare.entity.Clinic;
import com.medicare.medicare.entity.MedService;
import com.medicare.medicare.exception.DuplicateResourceException;
import com.medicare.medicare.repository.ClinicRepository;
import com.medicare.medicare.repository.MedServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;

    public void save(Clinic clinic) throws DuplicateResourceException {
        clinicRepository.save(clinic);
    }

    public List<Clinic> findAllClinics(){
        return clinicRepository.findAll();
    }

    public List<Clinic> findClinicById (int id){
       return clinicRepository.findById(id);
    }

    public List<Clinic> findWorkingDateTime(){
        return (List<Clinic>) clinicRepository.findWorkingDateTime();
    }
}
