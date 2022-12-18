package com.medicare.medicare.controller;

import com.medicare.medicare.entity.Clinic;
import com.medicare.medicare.entity.MedService;
import com.medicare.medicare.service.ClinicService;
import com.medicare.medicare.service.MedServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final MedServiceService medServiceService;
    private final ClinicService clinicService;

    @GetMapping("/")
    public String mainPage(ModelMap modelMap){
        List<MedService> allMedServices = medServiceService.findAllMedServices();
        List<Clinic> workingDateTime = clinicService.findWorkingDateTime();

        modelMap.addAttribute("allMedServices", allMedServices);
        modelMap.addAttribute("workingDateTime", workingDateTime);
        return "index";
    }
}
