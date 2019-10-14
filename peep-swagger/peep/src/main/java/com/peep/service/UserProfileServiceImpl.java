package com.peep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peep.model.UserProfile;
import com.peep.repository.UserProfileRepository;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepo;

	@Override
	public UserProfile getUserProfile(long userId) {
		return userProfileRepo.findByUserId(userId);
	}

	@Override
	public UserProfile updateUserProfile(UserProfile userprofile) {
		return userProfileRepo.save(userprofile);
	}
}
