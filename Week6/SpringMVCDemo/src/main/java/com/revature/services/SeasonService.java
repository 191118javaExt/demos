package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Season;

public class SeasonService {
	
	private static List<Season> list = new ArrayList<>();
	
	static {
		list.add(new Season("Holiday", -300, -299, -280, 100, 62));
		list.add(new Season("Shopping", 142, 150, 188, 0, 10000));
	}

	public static List<Season> findAll() {
		return list;
	}
	
	public static Season upsert(Season s) {
		boolean found = false;
		for(int i = 0; i < list.size(); i++) {
			Season e = list.get(i);
			if(s.getName().equals(e.getName())) {
				list.set(i, s);
				found = true;
			}
		}
		
		if(!found) {
			list.add(s);
		}
		
		return s;
	}
	
	public static Season delete(int id) {
		Season s = list.get(id);
		list.remove(id);
		return s;
	}
}
