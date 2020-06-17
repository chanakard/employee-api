package com.chanakard.employee_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chanakard.employee_api.model.Status;
import com.chanakard.employee_api.repository.StatusRepository;

@RestController
@RequestMapping("/api/v1.0/")
public class StatusController {

	@Autowired
	StatusRepository repo;
	
	@GetMapping("/get-ref-all-title/{status_ref_table}")
	public ResponseEntity<List<Status>> getAllRefStatus(@PathVariable String status_ref_table) {

		List<Status> stt = repo.findByStatusReference(status_ref_table);
		return new ResponseEntity<List<Status>>(stt, HttpStatus.OK);		
	}
}
