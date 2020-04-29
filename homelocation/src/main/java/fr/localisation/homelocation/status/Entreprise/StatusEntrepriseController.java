package fr.localisation.homelocation.status.Entreprise;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusEntrepriseController {

	@Autowired
	private StatusEntrepriseRepository statusEntrepriseRepository;

	@PostMapping("/AddListStatusEnterprise")
	public void insertAddListStatusEnterprise(@RequestBody List<StatusEntreprise> StatusEnterprise) {

		statusEntrepriseRepository.saveAll(StatusEnterprise);
	}
}
