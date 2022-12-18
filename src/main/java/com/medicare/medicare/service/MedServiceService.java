package com.medicare.medicare.service;

import com.medicare.medicare.entity.MedService;
import com.medicare.medicare.exception.DuplicateResourceException;
import com.medicare.medicare.repository.MedServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedServiceService {

    private final MedServiceRepository medServiceRepository;

    public void save(MedService medService) throws DuplicateResourceException {
        medServiceRepository.save(medService);

    }

    public List<MedService> findAllMedServices(){
        return medServiceRepository.findAll();
    }

    public List<MedService> findServiceById (int id){
       return medServiceRepository.findById(id);
    }

    public void deleteMedServiceById(MedService medService){
        medServiceRepository.deleteById(medService.getId());
    }
}
