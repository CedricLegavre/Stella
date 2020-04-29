package fr.localisation.homelocation.departement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departement")
public class DepartementController {

	@Autowired
	DepartementRepository DepartementRepository;

	@GetMapping("/listDepartements")
	public List<Departement> departement() {

		return DepartementRepository.findAll();
	}

	@PostMapping("/AddDepartements")
	public void insertlistRegions(@RequestBody List<Departement> departements) {

		DepartementRepository.saveAll(departements);
	}
}