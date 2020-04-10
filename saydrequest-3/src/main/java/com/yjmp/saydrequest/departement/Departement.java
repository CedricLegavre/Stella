package com.yjmp.saydrequest.departement;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.yjmp.saydrequest.entity.student.Student;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nom;
	String numero;

}
