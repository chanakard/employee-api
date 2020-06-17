package com.chanakard.employee_api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chanakard.employee_api.model.Title;
import com.chanakard.employee_api.repository.TitleRepository;

@RestController
@RequestMapping("/api/v1.0/")
public class TitleController {

	@Autowired
	TitleRepository repo;
	
	@GetMapping("/get-all-title")
	public ResponseEntity<List<Title>> getAllEmployees() {

		List<Title> tit = repo.findAll();
		return new ResponseEntity<List<Title>>(tit, HttpStatus.OK);		
	}
}
