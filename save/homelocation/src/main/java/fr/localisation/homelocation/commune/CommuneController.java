package fr.localisation.homelocation.commune;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/commune")
public class CommuneController {

	@Autowired
	CommuneRepository communeRepository;

	@GetMapping("/listDepartements")
	public List<Commune> communes() {
//		return communeRepository.findAll(PageRequest.of(0, 20));
		return communeRepository.findAll();
	}

	@PostMapping("/addListCommunes")
	public void insertlistDepartements(@RequestBody List<Commune> communes) {

		communeRepository.saveAll(communes);
	}

}
