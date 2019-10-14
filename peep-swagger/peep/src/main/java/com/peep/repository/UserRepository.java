package com.peep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.peep.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByName(String name);

	public User findByEmail(String email);

	public User findByEmailAndPassword(String email, String password);

	public List<User> findByNameContaining(String name);

	@Query("FROM User u where u.id NOT In :followeesIds")
	public List<User> findAllButThese(List<Long> followeesIds);

}
