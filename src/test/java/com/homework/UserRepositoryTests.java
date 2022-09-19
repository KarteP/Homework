package com.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		
		assertEquals(user.getEmail(), existingUser.getEmail());
		assertEquals(user.getFirstName(), existingUser.getFirstName());
		assertEquals(user.getLastName(), existingUser.getLastName());
		assertEquals(user.getAddress(), existingUser.getAddress());
		assertEquals(user.getBirthDate(), existingUser.getBirthDate());
		assertEquals(user.getIsActive(), existingUser.getIsActive());
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
		
		assertEquals(email, user2.getEmail());
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

		assertEquals(1, savedUser.getRoles().size());
	}
}
