package ejb;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Remote
public class ColisOperationBean implements ColisOperation {
	
	@PersistenceContext
	private EntityManager em;

	public ColisOperationBean() {}

	@Override
	public Colis createColis(double weight, double price, String origin, String destination) {
		Colis colis = new Colis(weight, price, origin, destination);
		em.persist(colis);
		return colis;
	}

	@Override
	public Colis getColis(long id) {
		return em.find(Colis.class, id);
	}

}
