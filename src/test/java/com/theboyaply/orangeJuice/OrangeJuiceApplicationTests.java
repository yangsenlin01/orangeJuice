package com.theboyaply.orangeJuice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@SpringBootTest
class OrangeJuiceApplicationTests {

	@Test
	void contextLoads() {
	}

	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("secret"));

		String originalFileName = "tom.jpg";
		String path = "D:/myResource/securityFile/images/" + UUID.randomUUID().toString().replace("-", "");
		String fileName = path.substring(path.lastIndexOf("/") + 1);
		String filePath = path.substring(0, path.lastIndexOf("/") + 1);

		fileName = fileName + originalFileName.substring(originalFileName.lastIndexOf("."));
		System.out.println(path);
		System.out.println(fileName);
		System.out.println(filePath);
	}

}
