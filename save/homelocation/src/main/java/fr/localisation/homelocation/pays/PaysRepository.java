package fr.localisation.homelocation.pays;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PaysRepository extends JpaRepository<Pays, Long> {
	
	
}
