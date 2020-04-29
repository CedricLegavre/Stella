package fr.localisation.homelocation.commune;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommuneRepository extends JpaRepository<Commune, Long> {

}
