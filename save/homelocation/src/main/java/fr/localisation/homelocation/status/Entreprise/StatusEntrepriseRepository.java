package fr.localisation.homelocation.status.Entreprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StatusEntrepriseRepository extends JpaRepository<StatusEntreprise, Long> {

}
