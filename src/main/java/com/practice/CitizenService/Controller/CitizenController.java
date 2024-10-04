package com.practice.CitizenService.Controller;

import com.practice.CitizenService.Repository.CitizenRepository;
import com.practice.CitizenService.dto.Citizen;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CitizenController {
    @Autowired
    CitizenRepository citizenRepository;

    @PostMapping("/citizen")
    public void addCitizen(@RequestBody Citizen citizen){
        citizenRepository.save(citizen);
    }
    @GetMapping("/citizen/{id}")
    public Citizen getCitizenById(@PathVariable("id") Integer id){

        Optional<Citizen> citizenOPtional = citizenRepository.findById(id);
        return citizenOPtional.isPresent() ? citizenOPtional.get() : new Citizen();
    }

}
