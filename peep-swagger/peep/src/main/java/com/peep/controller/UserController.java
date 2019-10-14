package com.peep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peep.model.User;
import com.peep.model.UserProfile;
import com.peep.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/signup")
	public User signup(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		User user = null;
		try {
			user = new User();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);

			UserProfile userProfile = new UserProfile();
			userProfile.setUser(user);

			user.setUserProfile(userProfile);
			user = userService.create(user);
			user.setPassword("");

		} catch (Exception e) {
			user = null;
			e.printStackTrace();
		}
		return user;
	}

	@PostMapping(value = "/update")
	public User updateUser(@RequestParam long id, @RequestParam String name, @RequestParam String email,
			@RequestParam String password) {
		User user = null;
		try {
			user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user = userService.create(user);
			user.setPassword("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@GetMapping(value = "/get/{id}")
	public User getUser(@PathVariable("id") long id) {
		User user = null;
		try {
			user = userService.get(id);
			user.setPassword("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@GetMapping(value = "/search/{name}")
	public List<User> getUsersByName(@PathVariable("name") String name) {
		List<User> users = null;
		try {
			users = userService.getAllByName(name);
			for (User user : users) {
				user.setPassword("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@GetMapping(value = "/get-by-name/{name}")
	public User getUserByName(@PathVariable("name") String name) {
		User user = null;
		try {
			user = userService.getByName(name);
			user.setPassword("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@GetMapping(value = "/get-by-email/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		User user = null;
		try {
			user = userService.getByEmail(email);
			user.setPassword("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@GetMapping(value = "/people-to-follow/{userId}")
	public List<User> getPeopleToFollow(@PathVariable("userId") long userId) {
		try {
			List<User> users = userService.getPeopleToFollow(userId);
			for (User user : users) {
				user.setPassword("");
			}
			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping(value = "/authenticate/{email}/{password}")
	public User authenticate(@PathVariable("email") String email, @PathVariable("password") String password) {
		User user = null;
		try {
			user = userService.getByEmailAndPassword(email, password);
			user.setPassword("");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable("id") long id) {
		try {
			userService.delete(id);
			return "success";
		} catch (Exception e) {
			return "failed";
		}
	}

}
