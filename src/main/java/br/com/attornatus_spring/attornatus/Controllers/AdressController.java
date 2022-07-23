package br.com.attornatus_spring.attornatus.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.attornatus_spring.attornatus.Dtos.AdressDto;
import br.com.attornatus_spring.attornatus.Services.AdressServicesImpl;

@RestController
@RequestMapping("/endereço")
public class AdressController {

    @Autowired
    private AdressServicesImpl servicesAdresssImpl;


    @GetMapping
    public ResponseEntity<List<AdressDto>> listAllAdress(){
        return ResponseEntity.ok(servicesAdresssImpl.listAllAdress());
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<List<AdressDto>> findAllAdresPersonById(@PathVariable Long id){
        return ResponseEntity.ok(servicesAdresssImpl.listAllPersonAdressById(id));
    }

    @PostMapping("/pessoa/{id}")
    public ResponseEntity<AdressDto> registerAnewAdressForPerson(@PathVariable Long id, @RequestBody AdressDto adress){
        return ResponseEntity.ok(servicesAdresssImpl.registerAnewAdressForPerson(id, adress));
    }
}
