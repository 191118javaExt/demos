package com.revature.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Cave;
import com.revature.service.ForestService;

public class DispatcherUtil {

	private ForestService fs = new ForestService();
	private ObjectMapper om = new ObjectMapper();

	public String processGet(String entity, String get) {
		try {
			if (entity.equals("cave")) {
				if (get.equals("all")) {
					return om.writeValueAsString(fs.allCaves());
				}
			} else if (entity.equals("bear")) {
				if (get.equals("all")) {
					return om.writeValueAsString(fs.allBears());
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "error";
	}

}
