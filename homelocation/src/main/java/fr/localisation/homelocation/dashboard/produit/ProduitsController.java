package fr.localisation.homelocation.dashboard.produit;

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

	@Autowired
	ProduitRepository produitRepository;

	@Autowired
	ProduitService produitService;

	/**
	 * 
	 * @param model
	 * @param httpSession
	 * @return liste de toute les produits a afficher dans le menu de produit.
	 */

	@RequestMapping(value = "/ProduitsEntreprise", method = RequestMethod.GET)
	public String dashboardProduitsEntreprise(Model model, HttpSession httpSession) {

		String identifiantProfessionnal = (String) httpSession.getAttribute("mail");
		List<ProduitDisplay> listOfProduit = produitService.recupererListProduitProfessionnel(identifiantProfessionnal);
		model.addAttribute("Produits", listOfProduit);
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

		produitService.enregistrerProduitProfessionnel(file, produit);

		return dashboardProduitsEntreprise(model, httpSession);

	}

}
