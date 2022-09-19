package com.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.homework.user.Role;

public class RoleEntityTests {
    
    Role role = new Role();
    
    @Test
    void testSetId() {
        role.setId(10);
        assertEquals(10, role.getId());
    }

    @Test
    void testSetName() {
        role.setName("USER");
        assertEquals("USER", role.getName());
    }
}
