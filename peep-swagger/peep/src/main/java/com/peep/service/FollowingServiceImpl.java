package com.peep.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peep.model.Following;
import com.peep.model.User;
import com.peep.repository.FollowingRepository;
import com.peep.repository.UserRepository;

@Service
@Transactional
public class FollowingServiceImpl implements FollowingService {

	@Autowired
	private FollowingRepository followingRepo;

	@Autowired
	private UserRepository userRepo;

	@Override
	public void addFollowee(Following following) {
		followingRepo.save(following);
	}

	@Override
	public void removeFollowee(long userId, long followeeId) {
		followingRepo.deleteByUserIdAndFolloweeId(userId, followeeId);
	}

	@Override
	public List<User> getFollowing(long userId) {
		List<Long> followeesIds = followingRepo.findAllByUserId(userId);
		return (List<User>) userRepo.findAllById(followeesIds);
	}

	@Override
	public List<User> getFollowers(long userId) {
		List<Long> usersIds = followingRepo.findAllByFolloweeId(userId);
		return (List<User>) userRepo.findAllById(usersIds);
	}

	@Override
	public int getFollowingCount(long userId) {
		List<Long> followersIds = followingRepo.findAllByUserId(userId);
		return followersIds.size();
	}

	@Override
	public int getFollowersCount(long userId) {
		List<Long> usersIds = followingRepo.findAllByFolloweeId(userId);
		return usersIds.size();
	}

}
