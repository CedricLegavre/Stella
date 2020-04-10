package com.yjmp.saydrequest.entreprise;

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
public class Entreprise {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String nom;
	String capital;
	String Siren;
	String lastCapital;
	
	
}
