package fr.localisation.homelocation.dashboard;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.localisation.homelocation.enterprise.Enterprise;
import fr.localisation.homelocation.enterprise.EnterpriseRepository;

@Controller
public class DashboardController {

	@Autowired
	EnterpriseRepository enterpriseRepository;

	@GetMapping(value = "/MesInfosEntreprise")
	public String dashboardEntreprise(Model model, HttpSession httpSession, Enterprise entreprise) {

		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
		String username = securityContext.getAuthentication().getName();
		entreprise = enterpriseRepository.findByMail(username);

		if (entreprise.getId_StatusEntreprise().equals(4L)) {
			model.addAttribute("statusEntreprise", "En cours de validation");
		} else {
			model.addAttribute("statusEntreprise", "Actif");
		}
		model.addAttribute("ShowEnterprise", entreprise);
		httpSession.setAttribute("password", entreprise.getPassword());
		httpSession.setAttribute("adresse", entreprise.getAdresse());
		httpSession.setAttribute("CP", entreprise.getCodepostal());
		httpSession.setAttribute("ville", entreprise.getVille());
		httpSession.setAttribute("portable", entreprise.getTelPortable());
		httpSession.setAttribute("mail", entreprise.getMail());
		httpSession.setAttribute("siren", entreprise.getSiren());
		httpSession.setAttribute("nom", entreprise.getNom());
		httpSession.setAttribute("status", entreprise.getId_StatusEntreprise());
		return "/DashboardEntreprise/MesInfosEntreprise";

	}

	@RequestMapping(value = "/ProduitsEntreprise", method = RequestMethod.GET)
	public String dashboardProduitsEntreprise() {
		return "/DashboardEntreprise/ProduitsEntreprise";
	}

	@RequestMapping(value = "/CommandeEntreprise", method = RequestMethod.GET)
	public String dashboardCommandeEntreprise(Model model) {
		return "/DashboardEntreprise/CommandeEntreprise";
	}

	@RequestMapping(value = "/ReportingEntreprise", method = RequestMethod.GET)
	public String dashboardReportingEntreprise(Model model) {
		return "/DashboardEntreprise/ReportingEntreprise";
	}

	@RequestMapping(value = "/ForfaitEntreprise", method = RequestMethod.GET)
	public String dashboardForfaitEntreprise(Model model) {
		return "/DashboardEntreprise/ForfaitEntreprise";
	}

}
