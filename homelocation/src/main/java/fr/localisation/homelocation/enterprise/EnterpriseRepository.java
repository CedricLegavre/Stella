package fr.localisation.homelocation.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

}
