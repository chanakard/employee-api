package com.chanakard.employee_api.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.chanakard.employee_api.EmployeeApiApplication;
import com.chanakard.employee_api.model.Employee;
import com.chanakard.employee_api.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1.0/")
public class EmployeeController {

	@Autowired
	EmployeeRepository repo;

	@GetMapping("/get-all-employee")
	public ResponseEntity<Map<String, Object>> getAllEmployees(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "1") int size) {

		try {
			List<Employee> empList = new ArrayList<Employee>();
			Pageable paging = PageRequest.of(page, size);

			Page<Employee> pageTuts;

			pageTuts = repo.findAll(paging);

			empList = pageTuts.getContent();

			if (empList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			Map<String, Object> response = new HashMap<>();
			response.put("employees", empList);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/find-an-employee/{id}")
	public ResponseEntity<Employee> get(@PathVariable Integer id) {
	    try {
	    	Employee emp = repo.findById(id).get();
	        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }      
	}
	
	
	@PostMapping("/add-an-employee")
	public ResponseEntity<HttpStatus> add(@RequestBody Employee employee) {
		try {
	    	repo.save(employee);
	        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@DeleteMapping("/delete-an-employee/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Integer id) {
		try {
	    	repo.deleteById(id);
	        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@PutMapping("/edit-an-employee")
	public ResponseEntity<HttpStatus> edit(@RequestBody Employee employee) {
		try {
	    	Employee existing = repo.findById(employee.getEmployee_id()).get();
	    	existing.setEmployee_name(employee.getEmployee_name());
	    	existing.setEmployee_address(employee.getEmployee_address());
	    	existing.setEmployee_email(employee.getEmployee_email());
	    	existing.setEmployee_imgurl(employee.getEmployee_imgurl());
	    	existing.setEmployee_title(employee.getEmployee_title());
	    	existing.setEmployee_telephone(employee.getEmployee_telephone());
	    	existing.setEmployee_status(employee.getEmployee_status());
	    	existing.setEmployee_added_date(employee.getEmployee_added_date());
	    	repo.save(existing);
	        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	    } catch (NoSuchElementException e) {
	        return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	    }
	}
	

}
