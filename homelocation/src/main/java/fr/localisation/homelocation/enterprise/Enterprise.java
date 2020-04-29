package fr.localisation.homelocation.enterprise;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import fr.localisation.homelocation.departement.Departement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enterprise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotNull
	String nom;
	String raison_sociale;
	@NotNull
	String siren;
	@NotNull
	String mail;
	@NotNull
	String telPortable;
	@NotNull
	Long id_StatusEntreprise;
	@NotNull
	String adresse;
	@NotNull
	String codepostal;
	@NotNull
	String ville;
	@NotNull
	String password;
}
