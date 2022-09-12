package com.homework;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
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
        User user = userRepo.findByEmail(userEmail); // or service.getByEmail() if there is a service class
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

		redirectAttributes.addFlashAttribute("message", "The details have been updated.");

		return "redirect:/user";
	}

	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = userRepo.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	
	@PostMapping("/delete")
	public String deleteUser(@AuthenticationPrincipal CustomUserDetails loggedUser, 
	RedirectAttributes redirectAttributes) {
		String userEmail = loggedUser.getUsername();
        User user = userRepo.findByEmail(userEmail);
		user.setisActive(false);

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
