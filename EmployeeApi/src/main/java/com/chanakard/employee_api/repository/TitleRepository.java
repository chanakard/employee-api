package com.chanakard.employee_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chanakard.employee_api.model.Title;

public interface TitleRepository extends JpaRepository<Title, Integer> {

}
