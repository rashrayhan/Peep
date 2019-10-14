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

import com.peep.model.Peep;
import com.peep.model.User;
import com.peep.service.PeepService;
import com.peep.service.UserService;

@RestController
@RequestMapping(value = "/api/peep")
public class PeepController {

	@Autowired
	private UserService userService;

	@Autowired
	PeepService peepService;

	@PostMapping(value = "/post")
	public Peep postPeep(@RequestParam long userId, @RequestParam String text) {
		Peep peep = null;
		try {
			User user = userService.get(userId);
			peep = new Peep();
			peep.setText(text);
			peep.setUser(user);
			peep = peepService.create(peep);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return peep;
	}

	@GetMapping(value = "/get/{id}")
	public Peep getPeep(@PathVariable("id") long id) {
		return peepService.get(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deletePeep(@PathVariable("id") long id) {
		try {
			peepService.delete(id);
			return "success";
		} catch (Exception e) {
			return "failed";
		}
	}

//	@GetMapping(value = "/get-by-user")
//	public List<Peep> getPeepByUserId(@RequestParam long userId) {
	@GetMapping(value = "/get-by-user/{userId}")
	public List<Peep> getPeepsByUserId(@PathVariable("userId") long userId) {
		return peepService.getAllByUserId(userId);
	}

	@GetMapping(value = "/count/{userId}")
	public long getCount(@PathVariable("userId") long userId) {
		return peepService.countByUserId(userId);
	}

	@GetMapping(value = "/timeline/{userId}")
	public List<Peep> getTimeline(@PathVariable("userId") long userId) {
		return peepService.getTimeline(userId);
	}
}
