package com.peep.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.peep.model.Peep;

public interface PeepRepository extends CrudRepository<Peep, Long> {

	public long countByUserId(long userId);

	public List<Peep> findByUserId(long userId);

	@Query("FROM Peep p where p.userIdValue In :followersIds")
	public List<Peep> findAllByUserIds(List<Long> followersIds);

}
