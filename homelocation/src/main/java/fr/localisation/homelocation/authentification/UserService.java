package fr.localisation.homelocation.authentification;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	User findbyEmail(String email);

}
