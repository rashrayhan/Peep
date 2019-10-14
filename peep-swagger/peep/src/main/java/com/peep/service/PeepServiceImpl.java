package com.peep.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peep.model.Peep;
import com.peep.repository.FollowingRepository;
import com.peep.repository.PeepRepository;

@Service
public class PeepServiceImpl implements PeepService {

	@Autowired
	private PeepRepository peepRepo;

	@Autowired
	private FollowingRepository followingRepo;

	@Override
	public Peep create(Peep peep) {
		return peepRepo.save(peep);
	}

	@Override
	public Peep get(long id) {
		return peepRepo.findById(id).get();
	}

	@Override
	public void delete(long id) {
		peepRepo.deleteById(id);
	}

	@Override
	public long countByUserId(long userId) {
		return peepRepo.countByUserId(userId);
	}

	@Override
	public List<Peep> getAllByUserId(long userId) {
		return peepRepo.findByUserId(userId);
	}

	@Override
	public List<Peep> getTimeline(long userId) {
		try {
			List<Long> followersIds = followingRepo.findAllByUserId(userId);
			// add user peeps to timeline feeds
			followersIds.add(userId);
			return peepRepo.findAllByUserIds(followersIds);
		} catch (Exception e) {
			System.out.println("\n" + e.getMessage());
		}
		return null;

	}

}
