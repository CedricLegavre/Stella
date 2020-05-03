package fr.localisation.homelocation.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entreprise")
public class EnterpriseService {

	@Autowired
	EnterpriseRepository enterpriseRepository;

	@GetMapping("/infoEnterprise")
	public Enterprise infoEntreprise(@RequestBody String mail) {
		return enterpriseRepository.findByMail(mail);
	}

}
