package com.homework;

import org.junit.jupiter.api.Test;

import com.homework.user.Role;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleEntityTests {
    
    Role role = new Role();
    
    @Test
    void testSetId() {
        role.setId(10);
        assertThat(role.getId()).isEqualTo(10);
    }

    @Test
    void testSetName() {
        role.setName("USER");
        assertThat(role.getName()).isEqualTo("USER");
    }
}
