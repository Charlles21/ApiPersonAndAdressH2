package br.com.attornatus_spring.attornatus.Controllers;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonDto>> findPersonById(@PathVariable Long id){  
        if(servicesImplPerson.findPersonById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }          
        return ResponseEntity.ok(servicesImplPerson.findPersonById(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<PersonDto> registerAnewPerson(@RequestBody PersonDto person){          
                                
        return ResponseEntity.ok(servicesImplPerson.registerAnewPerson(person));      
      
    }



}
