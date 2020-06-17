package com.chanakard.employee_api.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int status_id;
	private String status_description;
	private String status_ref_table;
	private Date status_added_date;
	private int status_status;
}
