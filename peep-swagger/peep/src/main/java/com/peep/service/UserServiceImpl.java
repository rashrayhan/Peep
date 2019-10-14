package com.peep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peep.model.User;
import com.peep.repository.FollowingRepository;
import com.peep.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private FollowingRepository followingRepo;

	@Override
	public User get(long id) {
		return userRepo.findById(id).get();
	}

	@Override
	public User getByName(String name) {
		return userRepo.findByName(name);
	}

	@Override
	public User getByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<User> getAllByName(String name) {
		return userRepo.findByNameContaining(name);
	}

	@Override
	public User create(User user) {
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		return userRepo.save(user);
	}

	@Override
	public void delete(long id) {
		userRepo.deleteById(id);
	}

	@Override
	public Iterable<User> getAllByIds(List<Long> ids) {
		return userRepo.findAllById(ids);
	}

	@Override
	public List<User> getPeopleToFollow(long userId) {
		List<Long> followeesIds = followingRepo.findAllByUserId(userId);
		followeesIds.add(userId);
		return userRepo.findAllButThese(followeesIds);
//		System.out.println("-------->");
//		System.out.println(followeesIds.toString());
//		List<User> peopleToFollow = userRepo.findAllButThese(followeesIds);
//		System.out.println("-------->");
//		for (User user : peopleToFollow) {
//			System.out.println(user.getId());
//		}
//		return null;
//		List<Long> followersIds = followingRepo.findByUserId(userId);
//		System.out.println(fo);
//		return null;
	}

}
