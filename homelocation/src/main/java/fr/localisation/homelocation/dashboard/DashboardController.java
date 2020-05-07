package fr.localisation.homelocation.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {


	@RequestMapping(value = "/CommandeEntreprise", method = RequestMethod.GET)
	public String dashboardCommandeEntreprise(Model model) {
		return "/DashboardEntreprise/CommandeEntreprise";
	}

	@RequestMapping(value = "/ReportingEntreprise", method = RequestMethod.GET)
	public String dashboardReportingEntreprise(Model model) {
		return "/DashboardEntreprise/ReportingEntreprise";
	}

	@RequestMapping(value = "/ForfaitEntreprise", method = RequestMethod.GET)
	public String dashboardForfaitEntreprise(Model model) {
		return "/DashboardEntreprise/ForfaitEntreprise";
	}

}
