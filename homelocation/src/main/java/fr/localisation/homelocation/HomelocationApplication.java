package fr.localisation.homelocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class HomelocationApplication {

	@RequestMapping("/")
	public String acceuil() {

		return "index";
	}

	@RequestMapping("/index.html")
	public String acceuil2() {

		return "index";
	}

	public static void main(String[] args) {

		SpringApplication.run(HomelocationApplication.class, args);
	}

}
