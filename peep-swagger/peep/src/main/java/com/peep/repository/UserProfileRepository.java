package com.peep.repository;

import org.springframework.data.repository.CrudRepository;

import com.peep.model.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

	public UserProfile findByUserId(long userId);

}
