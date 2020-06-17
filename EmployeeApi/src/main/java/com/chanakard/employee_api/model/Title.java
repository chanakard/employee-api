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
public class Title {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int title_id;
	private String title_name;
	private Date title_added_date;
	private int title_status;

}
