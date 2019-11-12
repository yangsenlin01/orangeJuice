package com.theboyaply.orangeJuice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class OrangeJuiceApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("secret"));
	}

}
