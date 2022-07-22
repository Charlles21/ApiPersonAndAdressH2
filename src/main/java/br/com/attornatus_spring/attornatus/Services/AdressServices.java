package br.com.attornatus_spring.attornatus.Services;

import java.util.List;

import br.com.attornatus_spring.attornatus.Dtos.AdressDto;

public interface AdressServices {
    List<AdressDto> listAllAdress();
    List<AdressDto> listAllPersonAdressById(Long id);
}
