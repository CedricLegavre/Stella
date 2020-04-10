package com.yjmp.saydrequest.entity.student;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private Date Birthdate;

	public Student(Long id, String name, String email, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		Birthdate = birthdate;
	}
}