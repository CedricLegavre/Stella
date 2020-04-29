package fr.localisation.homelocation.region;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegionController {

	@Autowired
	private RegionRepository RegionRepository;

	@GetMapping("/listRegions")
	public List<Region> regions() {

		return RegionRepository.findAll();
	}

	@PostMapping("/AddListregions")
	public void insertlistRegions(@RequestBody List<Region> region) {

		RegionRepository.saveAll(region);
	}

}
