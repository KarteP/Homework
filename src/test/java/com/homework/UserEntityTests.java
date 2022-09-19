package com.homework;

import org.junit.jupiter.api.Test;

import com.homework.user.Role;
import com.homework.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class UserEntityTests {

    User user = new User();

    @Test
    void testSetId() {
        user.setId(10L);
        assertEquals(10L, user.getId());
    }
    
    @Test
    void testSetEmail() {
        user.setEmail("mari@gmail.com");
        assertEquals("mari@gmail.com", user.getEmail());
    }

    @Test
    void testSetPassword() {
        user.setPassword("mari123");
        assertEquals("mari123", user.getPassword());
    }

    @Test
    void testSetFirstName() {
        user.setFirstName("mari");
        assertEquals("mari", user.getFirstName());
    }

    @Test
    void testSetLastName() {
        user.setLastName("maasikas");
        assertEquals("maasikas", user.getLastName());
    }

    @Test
    void testSetAddress() {
        user.setAddress("Marja 1");
        assertEquals("Marja 1", user.getAddress());
    }

    @Test
    void testSetBirthDate() {
        user.setBirthDate(LocalDate.of(1996, 9, 9));
        assertEquals(LocalDate.of(1996, 9, 9), user.getBirthDate());
    }

    @Test
    void testSetIsActive() {
        user.setisActive(false);
        assertEquals(false, user.getIsActive());
    }

    @Test
    void testAddRoles() {
        user.addRole(new Role("ADMIN"));
        user.addRole(new Role("USER"));
        user.addRole(new Role("CUSTOMER"));
        assertEquals(3, user.getRoles().size());
    }
}
