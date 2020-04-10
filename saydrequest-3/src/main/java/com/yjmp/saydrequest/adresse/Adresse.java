package com.yjmp.saydrequest.adresse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String adresse;
	String numero;
	String rue;
	String adresseBis;

}
