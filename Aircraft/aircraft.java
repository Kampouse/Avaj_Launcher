package aircraft;
import java.util.HashMap;
import aircraft.*;

public abstract class aircraft {
  long id;
  String name;
  Coordinates coordinates;
  private long idCounter = 0;
  private String current_weather;

  private long nextId() {
    return id = ++idCounter;
  }
  protected void  updateCoords ( int weather_variation ) {
    System.out.println("update the coord  ");
          
  }
  protected String  weahterEffect( String weather,HashMap<String, String[]> weatherTrigger ) {
     String[] output = weatherTrigger.get(weather);
     //#TODO  replace this  for the randomness 
      return output[0];
  }

  aircraft(String name, Coordinates coordinates, String current_weather) {
    this.name = name;
    this.id = nextId();
    this.coordinates = coordinates;
    this.current_weather = current_weather;
  }


}
