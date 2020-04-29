package fr.localisation.homelocation.pays;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import fr.localisation.homelocation.commune.Commune;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String codepays;
	String pays;
	

}
