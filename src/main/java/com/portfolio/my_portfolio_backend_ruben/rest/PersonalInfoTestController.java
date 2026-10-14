package com.portfolio.my_portfolio_backend_ruben.rest;

import com.portfolio.my_portfolio_backend_ruben.model.PersonalInfo;
import com.portfolio.my_portfolio_backend_ruben.repository.IPersonalInfoRepository;
import com.portfolio.my_portfolio_backend_ruben.service.IPersonalInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

// Retorna algo
@RestController
@RequestMapping("/api/test-personal-info")
public class PersonalInfoTestController {

    private final IPersonalInfoService personalInfoService;

    public PersonalInfoTestController(IPersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @GetMapping("/all")
    public List<PersonalInfo> getAllPersonalInfo(){
        return personalInfoService.findAll();
    }

    @GetMapping("/{id}")
    public PersonalInfo getPersonalInfoById(@PathVariable Long id){
        Optional<PersonalInfo> info = personalInfoService.findById(id);
        if(info.isPresent())
        {
            return info.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Información personal no disponible en el ID: " + id);
        }
    }

    // Enviar datos a la DB
    @PostMapping
    public ResponseEntity<PersonalInfo> createPersonalInfo(@RequestBody PersonalInfo personalInfo){
        PersonalInfo newPersonalInfo = personalInfoService.save(personalInfo);
        return new ResponseEntity<>(newPersonalInfo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public PersonalInfo update(@PathVariable Long id, @RequestBody PersonalInfo personalInfo){
        personalInfo.setId(id);
        return personalInfoService.save(personalInfo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personalInfoService.deleteById(id);
    }

}
