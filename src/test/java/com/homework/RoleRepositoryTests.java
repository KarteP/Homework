package com.homework;

import static org.assertj.core.api.Assertions.assertThat;

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
 
    @Autowired private RoleRepository repo;
     
    @Test
    public void testCreateRoles() {
        Role user = new Role("User");
        Role admin = new Role("Admin");
        Role customer = new Role("Customer");
        
        List<Role> roles = new ArrayList<>();
        roles.add(user);
        roles.add(admin);
        roles.add(customer);

        repo.saveAll(roles);
         
        List<Role> listRoles = repo.findAll();
         
        assertThat(listRoles.size()).isEqualTo(3);
    }
     
}