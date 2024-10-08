package com.practice.CitizenService.Controller;

import com.practice.CitizenService.Repository.CitizenRepository;
import com.practice.CitizenService.dto.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citizen")
@EnableDiscoveryClient
public class CitizenController {
    @Autowired
    CitizenRepository citizenRepository;

    @PostMapping("/")
    public void addCitizen(@RequestBody Citizen citizen){
        citizenRepository.save(citizen);
    }


    @GetMapping("/{id}")
    public Citizen getCitizenById(@PathVariable("id") Integer id){

        Optional<Citizen> citizenOPtional = citizenRepository.findById(id);
        return citizenOPtional.isPresent() ? citizenOPtional.get() : new Citizen();
    }

    @GetMapping("/byCenter/{id}")
    public List<Citizen> getCitizenByCenter(@PathVariable("id") Integer centerId){
        List<Citizen> citizenList = citizenRepository.findByVaccinationCenterId(centerId);
        return citizenList;
    }

}
