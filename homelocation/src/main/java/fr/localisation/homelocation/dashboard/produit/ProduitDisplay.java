package fr.localisation.homelocation.dashboard.produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProduitDisplay {

	String nom;
	String pays_origine;
	String description;
	String prixUnitaire;
	String prixPoids;
	String identifiantProfessionnal;
	String image;
}
