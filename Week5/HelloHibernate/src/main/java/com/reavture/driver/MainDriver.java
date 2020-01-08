package com.reavture.driver;

import com.reavture.model.SuperVillain;
import com.revature.dao.SuperVillainDao;

public class MainDriver {

	public static void main(String[] args) {
		System.out.println("Do the things");
		SuperVillain vill2=
				new SuperVillain("Rickie", "Mimic", 1_500_000_000);
		
		System.out.println(vill2);
		SuperVillainDao svdao = new SuperVillainDao();
		svdao.insert(vill2);
		System.out.println(svdao.selectById(1));
		System.out.println(svdao.selectByName("Rickie"));
		svdao.selectByName("Byrd");


	}

}
