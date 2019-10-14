package com.peep.service;

import com.peep.model.UserProfile;

public interface UserProfileService {

	public UserProfile getUserProfile(long userId);

	public UserProfile updateUserProfile(UserProfile userprofile);
}
