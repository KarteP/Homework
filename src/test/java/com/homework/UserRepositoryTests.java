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

import com.homework.user.Role;
import com.homework.user.RoleRepository;
import com.homework.user.User;
import com.homework.user.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
    private UserRepository userRepo;
     
    @Autowired
    private RoleRepository roleRepo;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("mari1@gmail.com");
		user.setPassword("mari123");
		user.setFirstName("Mari");
		user.setLastName("Maasikas");
		user.setAddress("Marja 1");
		user.setBirthDate(LocalDate.of(1996, 9, 9));
		
		User savedUser = userRepo.save(user);
		
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
		user.setEmail("mari2@gmail.com");
		user.setPassword("mari123");
		user.setFirstName("Mari");
		user.setLastName("Maasikas");
		user.setAddress("Marja 1");
		user.setBirthDate(LocalDate.of(1996, 9, 9));
		userRepo.save(user);

		String email = "mari2@gmail.com";
		User user2 = userRepo.findByEmail(email);
		
		assertThat(user2.getEmail()).isEqualTo(email);
	}

	@Test
	public void testAddRoleToNewUser() {
		Role roleAdmin = roleRepo.findByName("Admin");
		
		User user = new User();
		user.setEmail("mari@gmail.com");
		user.setPassword("mari123");
		user.setFirstName("Mari");
		user.setLastName("Maasikas");
		user.setAddress("Marja 1");
		user.setBirthDate(LocalDate.of(1996, 9, 9));
		user.addRole(roleAdmin);       
		
		User savedUser = userRepo.save(user);
		
		assertThat(savedUser.getRoles().size()).isEqualTo(1);
	}

}
