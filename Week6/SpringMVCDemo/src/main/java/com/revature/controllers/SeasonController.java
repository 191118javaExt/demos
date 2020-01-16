package com.revature.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Season;
import com.revature.services.SeasonService;

@Controller
public class SeasonController {

	@RequestMapping(value = "/seasons", method = RequestMethod.GET)
	@ResponseBody // This annotation changes the return type from a view to JSON data
	public List<Season> findAll() {
		return SeasonService.findAll();
	}
	
	@GetMapping("/seasons/{id}")
	@ResponseBody
	public ResponseEntity<Season> findById(@PathVariable("id") int id) {
		List<Season> list = SeasonService.findAll();
		if(id >= list.size()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
		Season s = list.get(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	
	@PutMapping("/seasons")
	@ResponseBody
	public ResponseEntity<Season> upsert(@RequestBody Season s) {
		return ResponseEntity.ok(SeasonService.upsert(s));
	}
	
	@DeleteMapping("/seasons/{id}")
	@ResponseBody
	public ResponseEntity<Season> deleteById(@PathVariable("id") int id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(SeasonService.delete(id));
	}
}
