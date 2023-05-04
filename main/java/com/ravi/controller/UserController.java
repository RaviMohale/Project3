package com.ravi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ravi.binding.LoginForm;
import com.ravi.binding.RegistrationForm;
import com.ravi.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public String handleregistration(@ModelAttribute("user")RegistrationForm form,Model model) {
		
		boolean status = userService.signup(form);
		
		if(status) {
			model.addAttribute("successMsg", "Registration completed");
			
		}else {
			model.addAttribute("errMsg", "Choose unique email");
		}
		return "registration";
	}
	
	@GetMapping("/signup")
	public String registration(Model model) {
		model.addAttribute("user", new RegistrationForm());
		return "registration";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("longinform", new LoginForm());
		return "login";
	}

	
	@PostMapping("/login")
	public String loginPage(@ModelAttribute("loginform")LoginForm loginform ,Model model) {
	String status = userService.login(loginform);
		
	if(status.contains("success")) {
		return "redirect:/dashboard";
	}
	model.addAttribute("errMsg", status);
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashBoard() {
		System.out.println("dashboard method called...");
		return "dashboard";
	}
}
