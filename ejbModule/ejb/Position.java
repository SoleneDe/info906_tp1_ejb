package ejb;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Position implements Serializable {
	
	private static long currentId = 0;
	
	@Id
	private long id;
	private double latitude;
	private double longitude;
	private String place;

	public Position() {}

	public Position(double latitude, double longitude, String place) 
	{
		this.id = ++currentId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.place = place;
	}

	public long getId() {
		return id;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	
	

}
