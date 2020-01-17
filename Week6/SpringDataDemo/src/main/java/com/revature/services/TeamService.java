package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Team;
import com.revature.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private TeamRepository dao;
	
	public List<Team> findAll() {
		return dao.findAll();
	}
	
	public Team upsert(Team t) {
		Optional<Team> exists = dao.findById(t.getId());
		if(exists.isPresent()) {
			Team found = exists.get();
			found.setType(t.getType());
			found.setName(t.getName());
			found.setMembers(t.getMembers());
			return dao.save(found);
		} else {
			return dao.save(t);
		}
	}
}
