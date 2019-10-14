package com.peep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.peep.model.UserProfile;
import com.peep.service.UserProfileService;

@RestController
@RequestMapping(value = "/api/user")
public class UserProfileController {

	@Autowired
	UserProfileService userProfileService;

	@GetMapping(value = "/profile/{userId}")
	public UserProfile getUserProfile(@PathVariable("userId") long userId) {
		return userProfileService.getUserProfile(userId);
	}

	@PostMapping(value = "/profile/update")
	public UserProfile updateUserProfile(@RequestParam long user_id, @RequestParam String full_name,
			@RequestParam String mobile, @RequestParam String bio) {
		UserProfile userProfile = null;
		try {
			userProfile = userProfileService.getUserProfile(user_id);
			userProfile.setFullName(full_name);
			userProfile.setMobile(mobile);
			userProfile.setBio(bio);
			userProfile = userProfileService.updateUserProfile(userProfile);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userProfile;
	}
}
