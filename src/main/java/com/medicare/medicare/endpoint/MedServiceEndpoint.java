package com.medicare.medicare.endpoint;


import com.medicare.medicare.entity.MedService;
import com.medicare.medicare.exception.DuplicateResourceException;
import com.medicare.medicare.exception.EntityNotFundException;
import com.medicare.medicare.service.MedServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class MedServiceEndpoint {

    private final MedServiceService medServiceService;
    private final RestTemplate restTemplate;


    @GetMapping("/MedServices/{id}")
    public ResponseEntity getMedServiceById(@PathVariable("id") int id) throws EntityNotFundException {
        return ResponseEntity.ok(medServiceService.findServiceById(id));
    }

    @PostMapping("/MedServices")
    public ResponseEntity<?> createMedService(@RequestBody @Valid MedService medService) throws DuplicateResourceException { /*without @Valid annotation it will not work even if we put some annotations in entity for validation*/
        medServiceService.save(medService);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/MedServices")
    public ResponseEntity<MedService> updateMedService(@RequestBody MedService medService) throws DuplicateResourceException {
        if (medService.getId() == 0) {

            return ResponseEntity.badRequest().build();
        }
        medServiceService.save(medService);
        return ResponseEntity.ok(medService);
    }

    @DeleteMapping("/MedServices/{id}")
    public ResponseEntity<MedService> deleteMedServiceByID(@PathVariable("id") int id) {
            medServiceService.deleteMedServiceById(MedService.builder().build());
        return ResponseEntity.notFound().build();

    }

}
