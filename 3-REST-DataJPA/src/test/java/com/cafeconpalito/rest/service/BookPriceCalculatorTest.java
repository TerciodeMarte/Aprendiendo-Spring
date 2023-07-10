package com.cafeconpalito.rest.service;

import com.cafeconpalito.rest.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        // configuracion de la prueba
        Book book = new Book(null, "El señor de los anillos", "Author", 1000, 49.99, LocalDate.now());
        BookPriceCalculator calculator = new BookPriceCalculator();

        // se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);

        // comprobaciones aserciones
        assertTrue(price > 0);
        assertEquals(57.980000000000004,price);

    }
}