package com.homework;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository repo;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("mari@gmail.com");
		user.setPassword("mari123");
		user.setFirstName("Mari");
		user.setLastName("Maasikas");
		user.setAddress("Marja 1");
		user.setBirthDate(LocalDate.of(1996, 9, 9));
		
		User savedUser = repo.save(user);
		
		User existingUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(user.getEmail()).isEqualTo(existingUser.getEmail());
		assertThat(user.getFirstName()).isEqualTo(existingUser.getFirstName());
		assertThat(user.getLastName()).isEqualTo(existingUser.getLastName());
		assertThat(user.getAddress()).isEqualTo(existingUser.getAddress());
		assertThat(user.getBirthDate()).isEqualTo(existingUser.getBirthDate());
	}
	
	@Test
	public void testFindByEmail() {
		User user = new User();
		user.setEmail("mari@gmail.com");
		user.setPassword("mari123");
		user.setFirstName("Mari");
		user.setLastName("Maasikas");
		user.setAddress("Marja 1");
		user.setBirthDate(LocalDate.of(1996, 9, 9));
		repo.save(user);

		String email = "mari@gmail.com";
		User user2 = repo.findByEmail(email);
		
		assertThat(user2.getEmail()).isEqualTo(email);
	}
}
