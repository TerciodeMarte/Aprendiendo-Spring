package com.cafeconpalito.ejercicios;

import com.cafeconpalito.ejercicios.entities.Laptop;
import com.cafeconpalito.ejercicios.repository.RepositoryLaptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context= SpringApplication.run(Application.class, args);
        RepositoryLaptop repo= context.getBean(RepositoryLaptop.class);

        repo.save(new Laptop(null,"Lenovo","High",499.9,true));
        repo.save(new Laptop(null,"HP","Low",999,false));
    }

}
