package fr.localisation.homelocation.produit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByIdentifiantProfessionnal(String identifiantProfessionnal);

}
