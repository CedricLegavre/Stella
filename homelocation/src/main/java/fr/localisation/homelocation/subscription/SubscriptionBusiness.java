package fr.localisation.homelocation.subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.localisation.homelocation.adresse.Adresse;
import fr.localisation.homelocation.enterprise.Enterprise;
import fr.localisation.homelocation.enterprise.EnterpriseRepository;
import fr.localisation.homelocation.status.Entreprise.StatusEntreprise;

@Controller
public class SubscriptionBusiness {

	@Autowired
	EnterpriseRepository enterpriseRepository;

	@RequestMapping(value = "/subscription", method = RequestMethod.GET)
	public String formSubscriptionEntreprise(Model model) {

		model.addAttribute("Entrerprise", new Enterprise());

		return "subscriptionEnterprise";
	}

	@PostMapping(value = "/saveSubscription")
	public String saveformSubscriptionEntreprise(Model model, Enterprise enterprise) {

		StatusEntreprise statusEntreprise = new StatusEntreprise();
		statusEntreprise.setId(4L);
		enterprise.setId_StatusEntreprise(statusEntreprise.getId());

		enterpriseRepository.save(enterprise);

		return "dashboardEnterprise";
	}

}
