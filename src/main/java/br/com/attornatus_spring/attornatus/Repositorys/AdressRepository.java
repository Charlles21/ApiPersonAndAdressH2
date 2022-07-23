package br.com.attornatus_spring.attornatus.Repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.attornatus_spring.attornatus.Models.Adress;
@Repository
public interface AdressRepository extends JpaRepository<Adress, Long>{
    List<Adress> findAllAdressByPerson_Id(Long id);   

}
