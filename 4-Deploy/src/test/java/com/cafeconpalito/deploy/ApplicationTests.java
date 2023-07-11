package com.cafeconpalito.deploy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
		System.getenv().forEach((key,value)-> System.out.println(key + " "+ value));
	}

}
