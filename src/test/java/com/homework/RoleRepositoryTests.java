package com.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.homework.user.Role;
import com.homework.user.RoleRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
 
    @Autowired private RoleRepository roleRepo;
     
    //Data added in import.sql causes failure.
    @Test
    public void testCreateRoles() {
        Role user = new Role("USER");
        Role admin = new Role("ADMIN");
        Role customer = new Role("CUSTOMER");
        
        List<Role> roles = new ArrayList<>();
        roles.add(user);
        roles.add(admin);
        roles.add(customer);

        roleRepo.saveAll(roles);
         
        List<Role> listRoles = roleRepo.findAll();
        
        assertEquals(3, listRoles.size());
    }

    @Test
	public void testFindByName() {
        Role role = new Role("EDITOR");
        roleRepo.save(role);

        Role foundRole = roleRepo.findByName("EDITOR");
		
        assertEquals("EDITOR", foundRole.getName());
	}
     
}