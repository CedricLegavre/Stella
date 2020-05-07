package fr.localisation.homelocation.dashboard;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.localisation.homelocation.produit.Produit;
import fr.localisation.homelocation.produit.ProduitRepository;

@Controller
public class ProduitsController {

	@Autowired
	ProduitRepository produitRepository;

	@RequestMapping(value = "/ProduitsEntreprise", method = RequestMethod.GET)
	public String dashboardProduitsEntreprise(Model model, HttpSession httpSession) {

		String identifiantProfessionnal = (String) httpSession.getAttribute("mail");
		List<Produit> listOfProduit = produitRepository.findByIdentifiantProfessionnal(identifiantProfessionnal);
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
	public String AddProduitsEntreprise(Model model, HttpSession httpSession, Produit produit) {

		String identifiantProfessionnal = (String) httpSession.getAttribute("mail");
		produit.setIdentifiantProfessionnal(identifiantProfessionnal);
		produitRepository.save(produit);

		return dashboardProduitsEntreprise(model, httpSession);

	}
}
