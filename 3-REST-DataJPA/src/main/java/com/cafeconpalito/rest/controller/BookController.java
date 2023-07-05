package com.cafeconpalito.rest.controller;

import com.cafeconpalito.rest.entities.Book;
import com.cafeconpalito.rest.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
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
    private BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }
    
    
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // recuperar y devolver los libros de base de datos
        return repo.findAll();
    }
    //PA MAÑANA
    /*
    @GetMapping("/api/books")
    public Book findOneById(Integer id){
        return repo.findById(1);
    }
    */
}
