package com.cafeconpalito.springsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class EncryptionTest {
    @Test
    void bcryptTest() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

        System.out.println(passwordEncoder.matches("adminn", hashedPassword));

    }

    @Test
    void bcryptCheckMultiplePasswords() {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = null;
        for (int i = 0; i < 2; i++) {
            hashedPassword = passwordEncoder.encode("admin");
            System.out.println(hashedPassword);
        }
    }

}
