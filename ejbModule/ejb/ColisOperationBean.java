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
		Position position = new Position(0, 0, origin);
		em.persist(position);
		colis.setPosition(position);
		em.persist(colis);
		return colis;
	}

	@Override
	public Colis getColis(long id) {
		return em.find(Colis.class, id);
	}
	
	@Override
	public Colis updateProgress(long id_colis, State state, double lat, double lon, String place)
	{
		Colis colis = changeState(em.find(Colis.class, id_colis), state);
		Position position = em.find(Position.class, colis.getPosition().getId());
		position.setLatitude(lat);
		position.setLongitude(lon);
		position.setPlace(place);
		
		return colis;
	}

	private Colis changeState(Colis colis, State state) {
		colis.setState(state);
		return colis;
	}

	private Colis changePosition(Colis colis, Position position) {
		colis.setPosition(position);
		return colis;
	}

}
