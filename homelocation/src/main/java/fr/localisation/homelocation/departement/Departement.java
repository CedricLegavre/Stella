package fr.localisation.homelocation.departement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotNull
	@Size(min = 2, max=255)
	String nom;
	@NotNull
	String code;
	@NotNull
	String codeRegion;

}
