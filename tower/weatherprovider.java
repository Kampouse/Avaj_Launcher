package  tower;
import aircraft.*;


public class weatherprovider {
	final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"}; 
	
	public static weatherprovider getProvider() {
		return new weatherprovider();
	}
	//@brief  generate the weather based on the coordinates of the aircraft
	public String getCurrentWeather(Coordinates cords) {
		// generate the weather based on the coordinates of the aircraft
		//return weather[(cords.getLongitude() + cords.getLatitude() + cords.getHeight()) % 4];
		return " ";
	}

}
