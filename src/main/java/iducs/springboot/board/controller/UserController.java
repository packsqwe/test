package iducs.springboot.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import iducs.springboot.board.domain.User;
import iducs.springboot.board.exception.ResourceNotFoundException;
import iducs.springboot.board.repository.UserRepository;
import iducs.springboot.board.service.UserService;

@Controller
//@RequestMapping("/users")
public class UserController {
	//@Autowired UserRepository userRepo; // Dependency Injection
	
	@Autowired UserService userService; // 의존성 주입(Dependency Injection) : 
	
	@PostMapping("/users/login")
	public String loginUser(@Valid User user, HttpSession session) {
		System.out.println("login process : ");
		User sessionUser = userService.getUserByUserId(user.getUserId()); //userRepo.findByUserId(user.getUserId());
		if(sessionUser == null) {
			System.out.println("id error : ");
			return "redirect:/login-form";
		}
		if(!sessionUser.getUserPw().equals(user.getUserPw())) {
			System.out.println("pw error : ");
			return "redirect:/login-form";
		}
		session.setAttribute("user", sessionUser);
		return "redirect:/";
	}	
	
	@PostMapping("/users")
	public String createUser(@Valid User user, Model model) {
		userService.saveUser(user); //userRepo.save(user);
		model.addAttribute("user", user);
		return "redirect:/users";
	}
	
	@GetMapping("/users")
	public String getAllUser(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "/users/list";
	}	
	/*
	@GetMapping("/users/{id}")
	public String getUserById(@PathVariable(value = "id") Long userId, Model model)
			throws ResourceNotFoundException {
		// orElseThrow() : 해당 값이 존재하는 경우 반환하고, 없는 경우 제공자(supplier)에 의해 제공되는 예외 반환
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id:: " + userId));
		model.addAttribute("user", user);
		return "user-info";
		//return ResponseEntity.ok().body(user);
	}
	@GetMapping("/users/n")
	public String getEmployeeByName(@Param(value = "name") String name, Model model)
			throws ResourceNotFoundException {
		System.out.println(name);
		List<User> users = userRepo.findByNameOrderByIdAsc(name);
		model.addAttribute("users", users);
		return "user-list";
	}
	@GetMapping("/users/c")
	public String getUserByCompany(@Param(value = "company") String company, Model model)
			throws ResourceNotFoundException {
		List<User> users = userRepo.findByCompany(company);
		model.addAttribute("users", users);
		return "user-list";
	}
	@PutMapping("/users/{id}")
	public String updateUserById(@PathVariable(value = "id") Long userId, @Valid User userDetails, Model model)
			throws ResourceNotFoundException {
		System.out.println("upupupup");
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		user.setName(userDetails.getName());
		user.setCompany(userDetails.getCompany());
		User userUpdate = userRepo.save(user);
		model.addAttribute("user", userUpdate);
		return "user-updated";
	}
	@PatchMapping("/users/{id}")
	//@RequestBody 사용하는 경우 
	public ResponseEntity<User> patchUserById(@PathVariable(value = "id") Long userId, @Valid  User userDetails, Model model)
			throws ResourceNotFoundException {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		user.setName(userDetails.getName());
		//user.setCompany(userDetails.getCompany());
		User userUpdate = userRepo.save(user);
		return ResponseEntity.ok(userUpdate);
	}
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable(value = "id") Long userId, Model model)
			throws ResourceNotFoundException {
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
		userRepo.delete(user);
		model.addAttribute("name", user.getName());
		return "user-deleted";
	}
*/
}
