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
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employee_id;

	private String employee_title;

	private String employee_name;

	private String employee_address;

	private String employee_telephone;

	private String employee_email;

	private String employee_imgurl;

	private Date employee_added_date;

	private int employee_status;

}
