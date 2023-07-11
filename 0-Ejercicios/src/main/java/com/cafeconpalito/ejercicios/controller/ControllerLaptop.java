package com.cafeconpalito.ejercicios.controller;

import com.cafeconpalito.ejercicios.entities.Laptop;
import com.cafeconpalito.ejercicios.repository.RepositoryLaptop;
import io.swagger.v3.oas.annotations.Hidden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerLaptop {
    private final Logger log = LoggerFactory.getLogger(ControllerLaptop.class);

    private RepositoryLaptop repo;

    public ControllerLaptop(RepositoryLaptop repo) {
        this.repo = repo;
    }
    @GetMapping("/api/laptop")
    public List<Laptop> findAll() {
        return repo.findAll();
    }

    @GetMapping("/api/laptop/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Integer id) {

        Optional<Laptop> LaptopOpt = repo.findById(id);
        // opcion 1
        if (LaptopOpt.isPresent()) {
            return ResponseEntity.ok(LaptopOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/api/laptop")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop) {
        if (laptop.getId() != null) {
            log.warn("El libro ya existe");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = repo.save(laptop);
        return ResponseEntity.ok(result);

    }

    @PutMapping("/api/laptop")
    public ResponseEntity<Object> update(@RequestBody Laptop laptop) {
        if (laptop.getId() == null) {
            log.warn("Estas actualizando un ordenador que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (!repo.existsById(laptop.getId())) {
            log.warn("Estas actualizando un ordenador que no existe");
            return ResponseEntity.notFound().build();
        }
        Laptop result = repo.save(laptop);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/api/laptop/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        if (!repo.existsById(id)) {
            log.warn("No existe el ordenador para borrar");
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptop")
    public ResponseEntity<Object> delete(){
        log.info("Borrando TODO");
        repo.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
