package ejb;

public interface ColisOperation {
	
	Colis createColis(double weight, double price, String origin, String destination);
	Colis getColis(long id);
	Colis updateProgress(long id_colis, State state, double lat, double lon, String place);

}
