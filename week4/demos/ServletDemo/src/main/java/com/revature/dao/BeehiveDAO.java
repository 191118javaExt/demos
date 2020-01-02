package com.revature.dao;

import java.util.List;

import com.revature.beans.Beehive;

public interface BeehiveDAO {

	public List<Beehive> getBeehives();
	public Beehive getBeehiveById(int id);
	
}
