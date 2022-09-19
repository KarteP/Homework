package com.homework;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homework.controller.AppController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private AppController controller;

	@Test
	public void contextLoads() throws Exception {
		assertNotEquals(null, controller);
	}
}
