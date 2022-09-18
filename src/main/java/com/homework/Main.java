package com.homework;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
//Spring Boot Update User Details and Refresh Username in Menu https://www.youtube.com/watch?v=aFx2SfG5fmY
//https://www.codejava.net/frameworks/spring-boot/get-logged-in-user-details
//https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial
//https://www.tutorialspoint.com/how-to-create-a-currency-converter-in-javascript
//https://stackoverflow.com/questions/70618518/when-does-spring-parse-string-to-localdate
//https://spring.io/guides/gs/testing-web/
//https://www.codejava.net/frameworks/spring-boot/spring-security-add-roles-to-user-examples


@SpringBootApplication
public class Main {

	//private static final Logger log = LoggerFactory.getLogger(ProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	/* 
	//Add data to database
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
	  return (args) -> {
		// save a few customers
		User u = new User();
		u.setEmail("m@m");
		u.setPassword("123456");
		u.setFirstName("mm");
		repository.save(u);


		// fetch all customers
		log.info("Users found with findAll():");
		log.info("-------------------------------");
		for (User customer : repository.findAll()) {
		  log.info(customer.toString());
		}
		log.info("");
  
	  };

	}
	*/
}
