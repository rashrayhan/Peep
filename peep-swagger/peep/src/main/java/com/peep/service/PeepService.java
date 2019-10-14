package com.peep.service;

import java.util.List;

import com.peep.model.Peep;

public interface PeepService {

	public Peep create(Peep peep);

	public Peep get(long id);

	public void delete(long id);

	public long countByUserId(long userId);

	public List<Peep> getAllByUserId(long userId);

	public List<Peep> getTimeline(long userId);
}
