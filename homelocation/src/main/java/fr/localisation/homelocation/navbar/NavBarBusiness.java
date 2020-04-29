package fr.localisation.homelocation.navbar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NavBarBusiness {
	
	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public String formSubscriptionEntreprise(Model model) {

		return "template";
	}

}
