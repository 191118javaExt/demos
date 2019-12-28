package com.revature.service;

import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.Cave;
import com.revature.dao.BearDAO;
import com.revature.dao.BearDAOImpl;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;

public class ForestService {
	
	private CaveDAO cd = new CaveDAOImpl();
	private BearDAO bd = new BearDAOImpl();

	public ForestService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Cave> allCaves(){
		return cd.getCaves();
	}
	
	public Cave caveById(int id) {
		return cd.getCaveById(id);
	}
	
	public List<Bear> allBears(){
		return bd.getBears();
	}
	
	public Bear bearById(int id) {
		return bd.getBearById(id);
	}

}
