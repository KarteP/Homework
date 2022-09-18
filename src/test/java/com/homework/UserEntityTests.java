package com.homework;

import org.junit.jupiter.api.Test;

import com.homework.user.Role;
import com.homework.user.User;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

public class UserEntityTests {

    User user = new User();

    @Test
    void testSetId() {
        user.setId(10L);
        assertThat(user.getId()).isEqualTo(10L);
    }
    
    @Test
    void testSetEmail() {
        user.setEmail("mari@gmail.com");
        assertThat(user.getEmail()).isEqualTo("mari@gmail.com");
    }

    @Test
    void testSetPassword() {
        user.setPassword("mari123");
        assertThat(user.getPassword()).isEqualTo("mari123");
    }

    @Test
    void testSetFirstName() {
        user.setFirstName("mari");
        assertThat(user.getFirstName()).isEqualTo("mari");
    }

    @Test
    void testSetLastName() {
        user.setLastName("maasikas");
        assertThat(user.getLastName()).isEqualTo("maasikas");
    }

    @Test
    void testSetAddress() {
        user.setAddress("marja 1");
        assertThat(user.getAddress()).isEqualTo("marja 1");
    }

    @Test
    void testSetBirthDate() {
        user.setBirthDate(LocalDate.of(1996, 9, 9));
        assertThat(user.getBirthDate()).isEqualTo(LocalDate.of(1996, 9, 9));
    }

    @Test
    void testSetIsActive() {
        user.setisActive(false);
        assertThat(user.getIsActive()).isEqualTo(false);
    }

    @Test
    void testSetRoles() {
        user.addRole(new Role());
        user.addRole(new Role());
        user.addRole(new Role());
        assertThat(user.getRoles().size()).isEqualTo(3);
    }
}
