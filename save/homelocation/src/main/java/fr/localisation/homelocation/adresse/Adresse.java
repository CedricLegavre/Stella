package fr.localisation.homelocation.adresse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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
	@NotNull
	String adresse;
	@NotNull
	String numero;
	@NotNull
	String rue;
	String adresseBis;
	@NotNull
	Long idregion;
	@NotNull
	Long iddepartement;
	@NotNull
	Long idville;

}
