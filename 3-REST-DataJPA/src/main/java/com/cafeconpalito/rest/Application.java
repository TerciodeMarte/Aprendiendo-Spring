package com.cafeconpalito.rest;

import com.cafeconpalito.rest.repository.BookRepository;
import com.cafeconpalito.rest.entities.Book;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
                ApplicationContext context= SpringApplication.run(Application.class, args);
                BookRepository repo= context.getBean(BookRepository.class);
                
                // CRUD
		// crear libro
		Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1));
		Book book2 = new Book(null, "Homo Sapiens", "Yuval Noah", 450, 19.99, LocalDate.of(2013, 12, 1));
		// almacenar un libro
		System.out.println("Num libros en base de datos: " + repo.findAll().size());

		repo.save(book1);
		repo.save(book2);

		// recuperar todos los libros
		System.out.println("Num libros en base de datos: " + repo.findAll().size());

		// borrar un libro
		//repo.deleteById(1);

		System.out.println("Num libros en base de datos: " + repo.findAll().size());
	}

}
