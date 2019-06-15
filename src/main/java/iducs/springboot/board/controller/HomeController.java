package iducs.springboot.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import iducs.springboot.board.service.UserService;

@Controller
public class HomeController {
	
	@Autowired UserService userService; // 의존성 주입(Dependency Injection) : 
	
	@GetMapping("/")
	public String home(Model model) {
		return "index";
	}
	@GetMapping("/users/login-form")
	public String loginForm(Model model) {
		return "/users/login";
	}
	@GetMapping("/users/register-form")
	public String registerForm() {
		return "/users/register";
	}
	@GetMapping("/info-form")
	public String infoForm() {
		return "/info";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
