package fr.localisation.homelocation.subscription;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.localisation.homelocation.authentification.Role;
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
	public String saveformEntreprise(Model model, Enterprise enterprise) {

		PasswordEncoder passwordEncoder = passwordEncoder();

		StatusEntreprise statusEntreprise = new StatusEntreprise();
		statusEntreprise.setId(4L);
		enterprise.setId_StatusEntreprise(statusEntreprise.getId());
		enterprise.setPassword(passwordEncoder.encode(enterprise.getPassword()));
		Collection<Role> roles = new ArrayList<>();
		Role role = new Role();
		role.setDescription("Droit classique pour entreprise");
		role.setRole("ADMIN");
		roles.add(role);

		enterprise.setRoles(roles);
		enterpriseRepository.save(enterprise);
		return "dashboardEnterprise";
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
