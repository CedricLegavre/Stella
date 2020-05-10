package fr.localisation.homelocation.dashboard.produit;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fr.localisation.homelocation.produit.Produit;
import fr.localisation.homelocation.produit.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;

	public void enregistrerProduitProfessionnel(MultipartFile file, Produit produit) {

		try {
			// image en base 64
			// String image = Base64.getEncoder().encodeToString(file.getBytes());
			byte[] image = file.getBytes();
			produit.setImage(image);
			produitRepository.save(produit);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<ProduitDisplay> recupererListProduitProfessionnel(String mail) {

		List<Produit> listOfProduit = produitRepository.findByIdentifiantProfessionnal(mail);
		List<ProduitDisplay> listDisplay = convertListProduitToProduitDisplay(listOfProduit);
		return listDisplay;
	}

	private List<ProduitDisplay> convertListProduitToProduitDisplay(List<Produit> listOfProduit) {

		List<ProduitDisplay> ProduitDisplay = new ArrayList<>();

		for (int i = 0; i < listOfProduit.size(); i++) {

			ProduitDisplay produitDisplay = new ProduitDisplay();
			produitDisplay.setDescription(listOfProduit.get(i).getDescription());
			produitDisplay.setIdentifiantProfessionnal(listOfProduit.get(i).getIdentifiantProfessionnal());
			produitDisplay.setImage(Base64.getEncoder().encodeToString(listOfProduit.get(i).getImage()));
			produitDisplay.setNom(listOfProduit.get(i).getNom());
			produitDisplay.setPays_origine(listOfProduit.get(i).getPays_origine());
			produitDisplay.setPrixPoids(listOfProduit.get(i).getPrixPoids());
			produitDisplay.setPrixUnitaire(listOfProduit.get(i).getPrixUnitaire());
			ProduitDisplay.add(produitDisplay);
		}

		return ProduitDisplay;

	}

}
