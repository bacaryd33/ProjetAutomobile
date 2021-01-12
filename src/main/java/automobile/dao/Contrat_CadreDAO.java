package automobile.dao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import automobile.modele.Commande;
import automobile.modele.Contrat_Cadre;
import automobile.modele.Entreprise;
import automobile.modele.Fidelisation;
import automobile.modele.RapportJournalier;
import pizza.spring.exception.PasDeCommandeSuivanteException;

@Repository
public class Contrat_CadreDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void sauver(Contrat_Cadre pContrat_Cadre) {
		em.persist(pContrat_Cadre);
	}

	public Entreprise getEntrepriseById(Long pidEntreprise) {
		return em.find(Entreprise.class, pidEntreprise);
	}
	
	public List<Entreprise> getEntreprises() {
		return em.createQuery("select e from Entreprise e where e.id = nEntreprise", Entreprise.class)
				 .getResultList();
	}
	
	public List<Contrat_Cadre> getContrat_Cadre() {
		return em.createQuery("select * from contrat_cadre cc", Contrat_Cadre.class)
				 .getResultList();
	}
	
	public Contrat_Cadre getContratCadreById(Long pidContratCadre) {
		return em.find(Contrat_Cadre.class, pidContratCadre);
	}
}
