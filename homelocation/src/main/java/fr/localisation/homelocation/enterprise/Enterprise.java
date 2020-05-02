package fr.localisation.homelocation.enterprise;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import fr.localisation.homelocation.authentification.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Enterprise implements Serializable {

	@Id
	@NotNull
	String mail;

	@NotNull
	String nom;
	String raison_sociale;
	@NotNull
	String siren;

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
	@ManyToMany
	@JoinTable(name = "USERS_ROLES")
	@NotNull
	Collection<Role> roles;
}
