package com.medicare.medicare.controller;

import com.medicare.medicare.entity.MedService;
import com.medicare.medicare.service.MedServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MedServiceService medServiceService;

    @GetMapping("/")
    public String mainPage(ModelMap modelMap){
        List<MedService> allMedServices = medServiceService.findAllMedServices();
        modelMap.addAttribute("allMedServices", allMedServices);
        return "index";
    }
}
