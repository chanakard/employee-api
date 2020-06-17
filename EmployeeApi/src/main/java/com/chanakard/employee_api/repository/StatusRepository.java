package com.chanakard.employee_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chanakard.employee_api.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

	
	@Query("SELECT s FROM Status s where s.status_ref_table = :statusRef") 
	List<Status> findByStatusReference(@Param("statusRef") String sReference);
}
