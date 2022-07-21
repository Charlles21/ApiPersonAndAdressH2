package br.com.attornatus_spring.attornatus.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus_spring.attornatus.Dtos.PersonDto;

import br.com.attornatus_spring.attornatus.Services.PersonServicesImpl;

@RestController
@RequestMapping("/pessoas")
public class PersonController {
    
    @Autowired
    private PersonServicesImpl servicesImplPerson;


    @GetMapping("/listar")
    public ResponseEntity<List<PersonDto>> listAllPerson(){
        
        return ResponseEntity.ok(servicesImplPerson.listAllPerson());
    }

    @PutMapping("/cadastrar")
    public PersonDto registerAnewPerson(@RequestBody PersonDto person){       

        return servicesImplPerson.registerAnewPerson(person);
    }



}
