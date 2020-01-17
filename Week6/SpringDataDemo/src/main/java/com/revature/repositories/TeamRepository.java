package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
