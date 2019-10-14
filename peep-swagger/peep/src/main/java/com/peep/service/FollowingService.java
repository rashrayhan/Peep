package com.peep.service;

import java.util.List;

import com.peep.model.Following;
import com.peep.model.User;

public interface FollowingService {
	// follow
	void addFollowee(Following following);

	// unfollow
	void removeFollowee(long userId, long followeeId);

	List<User> getFollowing(long userId);

	List<User> getFollowers(long userId);

	int getFollowingCount(long userId);

	int getFollowersCount(long userId);

}
