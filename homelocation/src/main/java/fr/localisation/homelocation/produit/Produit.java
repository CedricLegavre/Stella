package fr.localisation.homelocation.produit;

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
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nom;
	String pays_origine;
	String description;
	String prixUnitaire;
	String prixPoids;
	// identifiant auquelle appartient ces produits.
	String identifiantProfessionnal;
}
