package com.sami.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:mysql://localhost:3306/autopro",
		"spring.datasource.username=root",
		"spring.datasource.password=root",
		"spring.jpa.hibernate.ddl-auto=update"
})
class ApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
