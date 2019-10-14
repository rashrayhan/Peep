package com.peep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peep.model.Following;
import com.peep.model.User;
import com.peep.service.FollowingService;
import com.peep.service.UserService;

@RestController
@RequestMapping(value = "/api/following" + "")
public class FollowingController {

	@Autowired
	FollowingService follwoingService;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/follow/{userId}/{followeeId}")
	public String follow(@PathVariable("userId") long userId, @PathVariable("followeeId") long followeeId) {
		try {
			User user = userService.get(userId);
			User followee = userService.get(followeeId);
			if (user == null || followee == null) {
				return "failed! user doesn't exist";
			}
			Following following = new Following();
			following.setUserId(userId);
			following.setFolloweeId(followeeId);
			follwoingService.addFollowee(following);
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}

	@PostMapping(value = "/unfollow/{userId}/{followeeId}")
	public String unfollow(@PathVariable("userId") long userId, @PathVariable("followeeId") long followeeId) {
		try {
			User user = userService.get(userId);
			User followee = userService.get(followeeId);
			if (user == null || followee == null) {
				return "failed! user doesn't exist";
			}
			follwoingService.removeFollowee(userId, followeeId);
			return "success";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}

	@GetMapping(value = "/followers/{userId}")
	public List<User> getFollowers(@PathVariable("userId") long userId) {
		try {
			User user = userService.get(userId);
			if (user == null) {
				return null;
			}
			List<User> users = follwoingService.getFollowers(userId);
			for (User user2 : users) {
				user2.setPassword("");
			}
			return users;

		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return null;
	}

	@GetMapping(value = "/followees/{userId}")
	public List<User> getFollowees(@PathVariable("userId") long userId) {
		try {
			User user = userService.get(userId);
			if (user == null) {
				return null;
			}
			List<User> users = follwoingService.getFollowing(userId);
			for (User user2 : users) {
				user2.setPassword("");
			}
			return users;

		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return null;
	}

	@GetMapping(value = "/followers-count/{userId}")
	public int getFollowersCount(@PathVariable("userId") long userId) {
		try {
			User user = userService.get(userId);
			if (user == null) {
				return 0;
			}
			int count = follwoingService.getFollowersCount(userId);
			return count;

		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return 0;
	}

	@GetMapping(value = "/followees-count/{userId}")
	public int getFolloweesCount(@PathVariable("userId") long userId) {
		try {
			User user = userService.get(userId);
			if (user == null) {
				return 0;
			}
			int count = follwoingService.getFollowingCount(userId);
			return count;

		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return 0;
	}

}
