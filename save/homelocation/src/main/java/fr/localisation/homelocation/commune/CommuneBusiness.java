package fr.localisation.homelocation.commune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommuneBusiness {

	@Autowired
	CommuneRepository communeRepository;

	@GetMapping(path = "/communes")
	public String listecommunes(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "50") int size) {

		Page<Commune> pageCommunes = communeRepository.findAll(PageRequest.of(page, size));
		model.addAttribute("listeCommunes", pageCommunes);
		model.addAttribute("nombrePagesCommunes", new int[pageCommunes.getTotalPages()]);
		model.addAttribute("paggecourante", page);
		model.addAttribute("pagesize", size);
		return "communes";
	}

}
