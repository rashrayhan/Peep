package com.peep.service;

import java.util.List;

import com.peep.model.User;

public interface UserService {

	public User get(long id);

	public User getByName(String name);

	public User getByEmail(String email);

	public User getByEmailAndPassword(String email, String password);

	public List<User> getAllByName(String name);

	public Iterable<User> getAllByIds(List<Long> ids);

	public List<User> getPeopleToFollow(long userId);

	public User create(User user);

	public User update(User user);

	public void delete(long id);
}
