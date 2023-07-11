package com.cafeconpalito.ejercicios.repository;

import com.cafeconpalito.ejercicios.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLaptop extends JpaRepository<Laptop,Integer> {

}
