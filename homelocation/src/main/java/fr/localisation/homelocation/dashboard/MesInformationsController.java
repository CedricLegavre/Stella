package fr.localisation.homelocation.dashboard;

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

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
