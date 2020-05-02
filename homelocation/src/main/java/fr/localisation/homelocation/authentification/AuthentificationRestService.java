package fr.localisation.homelocation.authentification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthentificationRestService {

	// retourne les informations de la sessions en cours.

	@RequestMapping(value = "/getLogedUser")
	public Map<String, Object> getLogedUser(HttpSession httpSession) {

		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");

		String username = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		for (GrantedAuthority ga : securityContext.getAuthentication().getAuthorities()) {

			roles.add(ga.getAuthority());
		}

		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		params.put("roles", roles);
		return params;

	}

}
