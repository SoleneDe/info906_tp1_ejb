package ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Colis implements Serializable {
	
	private static long currentId = 0;
	
	@Id
	private long id;
	private double weight;
	private double price;
	private String origin;
	private String destination;
	private Position position;
	private State state;

	public Colis() {}

	public Colis(double weight, double price, String origin, String destination) {
		this.id = ++currentId;
		this.weight = weight;
		this.price = price;
		this.origin = origin;
		this.destination = destination;
		//this.position = new Position(0, 0, origin);
		this.position = null;
		this.state = State.REGISTRATION;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public long getId() {
		return id;
	}

	public double getWeight() {
		return weight;
	}

	public double getPrice() {
		return price;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
