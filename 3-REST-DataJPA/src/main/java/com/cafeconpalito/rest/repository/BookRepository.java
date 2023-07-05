package com.cafeconpalito.rest.repository;

import com.cafeconpalito.rest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TerciodeMarte
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    
}
