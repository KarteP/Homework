package com.homework.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.homework.user.CustomUserDetails;
import com.homework.user.Role;
import com.homework.user.RoleRepository;
import com.homework.user.User;
import com.homework.user.UserRepository;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		User user = new User();

		Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);

		model.addAttribute("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register_success")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
		
		return "register_success";
	}

	@GetMapping("/user")
	public String showUserProfileUpdate(Model model, @AuthenticationPrincipal CustomUserDetails loggedUser) {
		String userEmail = loggedUser.getUsername();
        User user = userRepo.findByEmail(userEmail);
		model.addAttribute("user", user);

		return "user_update";
	}

	//saves updated details
	@PostMapping("/process_update")
	public String processUpdate(User user, @AuthenticationPrincipal CustomUserDetails loggedUser, 
	RedirectAttributes redirectAttributes) {
		loggedUser.setEmail(user.getEmail());
		loggedUser.setFirstName(user.getFirstName());
		loggedUser.setLastName(user.getLastName());
		loggedUser.setAddress(user.getAddress());
		loggedUser.setBirthDate(user.getBirthDate());
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);

		redirectAttributes.addFlashAttribute("message", "The details have been updated.");

		return "redirect:/user";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}

	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = userRepo.getReferenceById(id);
		List<Role> listRoles = roleRepo.findAll();
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);
		return "user_form";
	}

	@PostMapping("/users/save")
	public String saveUser(User user) {
		userRepo.save(user);
		
		return "redirect:/users";
	}
	
	@PostMapping("/delete")
	public String deleteUser(@AuthenticationPrincipal CustomUserDetails loggedUser, 
	RedirectAttributes redirectAttributes) {
		String userEmail = loggedUser.getUsername();
        User user = userRepo.findByEmail(userEmail);
		
		user.setisActive(false);
		userRepo.save(user);

		redirectAttributes.addFlashAttribute("message", "You have deleted your account successfully.");
		
		return "redirect:/";
	}

	@GetMapping("/currency")
	public String currency() throws IOException {
	  return "currency";
	}

	@GetMapping("/403")
	public String errorAccessDenied() {
		return "403";
	}
}
