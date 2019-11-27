package com.revature.interfaces;

public class Driver {
	public static void main(String[] args) {
		Chair c = new Chair();
		c.color = "red";
		c.comfiness = 4;
		c.cost = 12;
		c.numOfTimesSatUpon = 0;
		c.style = "Eclectic";
		c.texture = "sharp";
		
		c.sit();
		c.recline(100);
		c.massage();
	}

}
