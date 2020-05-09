package fr.localisation.homelocation.dashboard.produit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import fr.localisation.homelocation.produit.Produit;
import fr.localisation.homelocation.produit.ProduitRepository;

@Service
public class ProduitUploadImageService {

	@Autowired
	private ProduitRepository produitRepository;

	public void saveFile(MultipartFile file, Produit produit) {

		try {
			produit.setImage(file.getBytes());
			produitRepository.save(produit);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Produit> getFile(String mail) {
		return (produitRepository.findByIdentifiantProfessionnal(mail));
	}

}
