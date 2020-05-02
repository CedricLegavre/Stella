package fr.localisation.homelocation.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.localisation.homelocation.enterprise.EnterpriseRepository;
import fr.localisation.homelocation.produit.ProduitRepository;


@Controller
public class DashboardController {

	@Autowired
	EnterpriseRepository enterpriseRepository;

	@Autowired
	ProduitRepository produitRepository;

	@RequestMapping(value = "/dashboardEnterprise", method = RequestMethod.GET)
	public String dashboardEntreprise(Model model) {
		return "dashboardEnterprise";
	}

}
