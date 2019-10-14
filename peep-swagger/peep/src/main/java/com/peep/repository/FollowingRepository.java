package com.peep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.peep.model.Following;

public interface FollowingRepository extends CrudRepository<Following, Long> {

	void deleteByUserIdAndFolloweeId(long userId, long followeeId);

	@Query("SELECT followeeId FROM Following f WHERE f.userId = :id ")
	public List<Long> findAllByUserId(@Param("id") long userId);

	@Query("SELECT userId FROM Following f WHERE f.followeeId = :id ")
	public List<Long> findAllByFolloweeId(@Param("id") long followeeId);

}
