package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Team;
import com.revature.services.TeamService;

@RestController
public class TeamController {
	
	@Autowired
	private TeamService ts;
	
	@GetMapping("/teams")
	public ResponseEntity<List<Team>> findAllTeams() {
		List<Team> teams = ts.findAll();
		if(teams.size() > 0) {
			return ResponseEntity.ok(teams);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PutMapping("/teams")
	public ResponseEntity<Team> upsert(@RequestBody Team t) {
		if(t != null) {
			return ResponseEntity.ok(ts.upsert(t));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
