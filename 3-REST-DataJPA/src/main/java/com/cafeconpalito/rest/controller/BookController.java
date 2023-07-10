package com.cafeconpalito.rest.controller;

import com.cafeconpalito.rest.entities.Book;
import com.cafeconpalito.rest.repository.BookRepository;
import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Hidden;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author TerciodeMarte
 */
@RestController
public class BookController {

    /*
    @GetMapping("/hola")
    public String holaMundo() {
        return "Como estan los maquinas,lo primero de todo";
    }
    
    @GetMapping("/bootstrap")
    public String bootstrap(){
        return """
                <!doctype html>
                <html lang="es">
                  <head>
                    <!-- Required meta tags -->
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                                
                    <!-- Bootstrap CSS -->
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
                                
                    <title>Hello, world!</title>
                  </head>
                  <body>
                    <h1>Hola mundo desde Spring Boot!</h1>
                     <a class="btn btn-primary" href="https://www.google.com"> Google </a>
                    <!-- Optional JavaScript; choose one of the two! -->
                                
                    <!-- Option 1: Bootstrap Bundle with Popper -->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
                                
                    <!-- Option 2: Separate Popper and Bootstrap JS -->
                    <!--
                    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
                    -->
                  </body>
                </html>
         
                """;
    }
     */
    private final Logger log = LoggerFactory.getLogger(BookController.class);
    private BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/books")
    public List<Book> findAll() {
        // recuperar y devolver los libros de base de datos
        return repo.findAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Integer id) {

        Optional<Book> bookOpt = repo.findById(id);
        // opcion 1
        if (bookOpt.isPresent()) {
            return ResponseEntity.ok(bookOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
        // opcion 2
        //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book) {
        if (book.getId() != null) {
            log.warn("El libro ya existe");
            return ResponseEntity.badRequest().build();
        }
        Book result = repo.save(book);
        return ResponseEntity.ok(result);

    }

    @PutMapping("/api/books")
    public ResponseEntity<Object> update(@RequestBody Book book) {
        if (book.getId() == null) {
            log.warn("Estas actualizando un libro que no existe");
            return ResponseEntity.badRequest().build();
        }
        if (!repo.existsById(book.getId())) {
            log.warn("Estas actualizando un libro que no existe");
            return ResponseEntity.notFound().build();
        }
        Book result = repo.save(book);
        return ResponseEntity.ok(result);
    }
   @DeleteMapping("/api/books/{id}")
   @Hidden
   public ResponseEntity<Object> delete(@PathVariable Integer id){
       if (!repo.existsById(id)) {
            log.warn("No existe el libro para borrar");
            return ResponseEntity.notFound().build();
        }
       repo.deleteById(id);
       return ResponseEntity.noContent().build();
   }
   
   @DeleteMapping("/api/books")
   public ResponseEntity<Object> delete(){
       log.info("Borrando TODO");
       repo.deleteAll();
       return ResponseEntity.noContent().build();
   }

}
