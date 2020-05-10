package fr.localisation.homelocation.dashboard.infoentreprise;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.localisation.homelocation.authentification.Role;
import fr.localisation.homelocation.enterprise.Enterprise;
import fr.localisation.homelocation.enterprise.EnterpriseRepository;
import fr.localisation.homelocation.status.Entreprise.StatusEntreprise;

@Controller
public class MesInformationsController {

	@Autowired
	EnterpriseRepository enterpriseRepository;

	@RequestMapping(value = "/MajInfosEntreprise", method = RequestMethod.GET)
	public String formMajInfosEntreprise(Model model, HttpSession httpSession) {

		Enterprise enterprise = new Enterprise();
		enterprise.setAdresse((String) httpSession.getAttribute("adresse"));
		enterprise.setTelPortable((String) httpSession.getAttribute("portable"));
		enterprise.setCodepostal((String) httpSession.getAttribute("CP"));
		enterprise.setVille((String) httpSession.getAttribute("ville"));
		enterprise.setSiren((String) httpSession.getAttribute("siren"));
		enterprise.setPassword((String) httpSession.getAttribute("password"));
		enterprise.setNom((String) httpSession.getAttribute("nom"));

		model.addAttribute("Entrerprise", enterprise);
		model.addAttribute("postable", (String) httpSession.getAttribute("portable"));
		model.addAttribute("password", httpSession.getAttribute("password"));
		model.addAttribute("CP", (String) httpSession.getAttribute("CP"));
		model.addAttribute("ville", httpSession.getAttribute("ville"));
		model.addAttribute("mail", httpSession.getAttribute("mail"));
		model.addAttribute("siren", httpSession.getAttribute("siren"));
		model.addAttribute("nom", httpSession.getAttribute("nom"));
		return "/DashboardEntreprise/MajInfosEntreprise";
	}
	

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

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
