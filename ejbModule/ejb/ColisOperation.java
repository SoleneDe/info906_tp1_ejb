package ejb;

public interface ColisOperation {
	
	Colis createColis(double weight, double price, String origin, String destination);
	Colis getColis(long id);

}
