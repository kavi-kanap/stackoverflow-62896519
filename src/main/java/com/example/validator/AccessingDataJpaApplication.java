package com.example.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AccessingDataJpaApplication {

	public static void main(String[] args) {
		MyEntity myEntity = new MyEntity();
		myEntity.setId(12345);
		myEntity.setRole("ROLE_ROOT");
		myEntity.setUserId(3);

		ConfigurableApplicationContext context = SpringApplication.run(AccessingDataJpaApplication.class);
		MyTableRepository repo = context.getBean(MyTableRepository.class);

		try {
			repo.save(myEntity);
		} catch(Exception e) {
			System.out.println(e.getCause().getCause());
			//prints
			//javax.validation.ConstraintViolationException:
			// Validation failed for classes [com.example.validator.MyEntity]
			// during persist time for groups [javax.validation.groups.Default, ]
		}

	}
}