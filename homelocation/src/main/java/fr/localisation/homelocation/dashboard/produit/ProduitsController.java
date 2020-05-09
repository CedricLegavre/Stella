package fr.localisation.homelocation.dashboard.produit;

import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import fr.localisation.homelocation.produit.Produit;
import fr.localisation.homelocation.produit.ProduitRepository;



@Controller
@Service
public class ProduitsController {

	public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	ProduitUploadImageService produitUploadImageService;

	@RequestMapping(value = "/ProduitsEntreprise", method = RequestMethod.GET)
	public String dashboardProduitsEntreprise(Model model, HttpSession httpSession) {

		String identifiantProfessionnal = (String) httpSession.getAttribute("mail");
		List<Produit> listOfProduit = produitUploadImageService.getFile(identifiantProfessionnal);	
		model.addAttribute("Produits", listOfProduit);
		model.addAttribute("image" , Base64.getEncoder().encodeToString(listOfProduit.get(3).getImage()));
		String toto = Base64.getEncoder().encodeToString(listOfProduit.get(3).getImage());
		return "/DashboardEntreprise/ProduitsEntreprise";
	}

	@RequestMapping(value = "/ProduitsEntrepriseAfterSave", method = RequestMethod.GET)
	public String dashboardProduitsEntrepriseAfterSave(Model model, HttpSession httpSession) {

		String identifiantProfessionnal = (String) httpSession.getAttribute("mail");
		List<Produit> listOfProduit = produitRepository.findByIdentifiantProfessionnal(identifiantProfessionnal);
		model.addAttribute("Produits", listOfProduit);
		return "/DashboardEntreprise/ProduitsEntreprise";
	}

	@RequestMapping(value = "/displayAddProduitsEntreprise", method = RequestMethod.GET)
	public String displayAddProduitsEntreprise(Produit produit) {
		return "/DashboardEntreprise/AddProduitsEntreprise";
	}

	@PostMapping(value = "/AddProduitEntreprise")
	public String AddProduitsEntreprise(Model model, HttpSession httpSession, Produit produit, MultipartFile file) {

		String identifiantProfessionnal = (String) httpSession.getAttribute("mail");
		produit.setIdentifiantProfessionnal(identifiantProfessionnal);

		produitUploadImageService.saveFile(file, produit);

		return dashboardProduitsEntreprise(model, httpSession);

	}

}
