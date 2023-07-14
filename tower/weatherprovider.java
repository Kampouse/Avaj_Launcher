package  tower;
import aircraft.*;


class weather_cord  extends Coordinates {
	String weather;
	 int coord;
	weather_cord(int x, int y, int z) {
		super(x, y, z);
	}
	weather_cord(Coordinates cords) {
		 
		super(cords.get_longitude(), cords.get_latitude(), cords.get_height());
	}
	weather_cord(int x, int y, int z, String weather) {
		super(x, y, z);
		this.weather = weather;
	}
	weather_cord(Coordinates cords, String weather) {
		super(cords.get_longitude(), cords.get_latitude(), cords.get_height());
		this.weather = weather;
	}
	weather_cord(weather_cord cords) {
		 
		super(cords.get_longitude(), cords.get_latitude(), cords.get_height());
		this.weather = cords.get_weather();
	}
	public Boolean equals(Coordinates cords) {
		if (cords.get_longitude() == this.get_longitude() && cords.get_latitude() == this.get_latitude() && cords.get_height() == this.get_height())
			return true;
		return false;
	}
	


	public String get_weather() {
		return weather;
	}
	public void set_weather(String weather) {
		this.weather = weather;
	}
	
}

public class weatherprovider {
	final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"}; 
	final int size = 1000;
	final  int map_height = size;	
	final  int map_width = size;	
	final  int map_depth = size;
	weather_cord map[][] = new weather_cord[1000][1000];


	weatherprovider () {
		for (int i = 0; i < 1000; i++) {
			 for (int j = 0; j < 1000; j++) 
			 {
				//
				 map[i][j] = new weather_cord( i, j,50, weather[(int)(Math.random() * 4) ]);
			 }
		}
	}
	public static weatherprovider getProvider() {
		return new weatherprovider();
	}
	//@brief  generate the weather based on the coordinates of the aircraft
	public String getCurrentWeather(Coordinates cords) {
	Coordinates temp = cords.normalize(50);
		return map[temp.get_longitude()][temp.get_latitude()].get_weather().toString();
		 
	}
	// @brief  change the weather at certain coordinates
	public   void setWeather(Coordinates cords) {
		Coordinates temp = cords.normalize(50);
		map[temp.get_longitude()][temp.get_latitude()].set_weather(weather[(int)(Math.random() * 4) ]);
	}
	public   weather_cord[][] getWeatherMap(){
		return map;
	}

}
