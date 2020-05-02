package fr.localisation.homelocation.pays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaysController {

	@Autowired
	private PaysRepository paysRepository;

	@GetMapping("/listPays")
	public List<Pays> pays() {

		return paysRepository.findAll();
	}

	@PostMapping("/AddListPays")
	public void insertlistRegions(@RequestBody List<Pays> pays) {

		paysRepository.saveAll(pays);
	}
	
}
