package fr.localisation.homelocation;

import java.io.File;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.localisation.homelocation.dashboard.produit.ProduitsController;

@Controller
@SpringBootApplication
@ComponentScan({ "fr.localisation.homelocation", "controller" })
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

		new File(ProduitsController.uploadDirectory).mkdir();
		SpringApplication.run(HomelocationApplication.class, args);
	}

}
