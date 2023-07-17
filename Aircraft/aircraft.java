package aircraft;
import java.util.HashMap;
import aircraft.*;

public abstract class aircraft {
  long id;
  String name;
  Coordinates coordinates;
  private int direction; // 0 = north, 1 = east, 2 = south, 3 = west
  private long idCounter = 0;
  private String current_weather;

  private long nextId() {
    return id = ++idCounter;
  }
  
  protected void  updateCoords ( Coordinates variation ){
         this.coordinates.variation(variation);
      }
  protected String  weahterEffect( String weather,HashMap<String, String[]> weatherTrigger ) {
     String[] output = weatherTrigger.get(weather);

      return output[Math.abs((int) (Math.random() * output.length))];
  }

  aircraft(String name, Coordinates coordinates, String current_weather) {
    this.name = name;
    this.id = nextId();
    this.coordinates = coordinates;
    this.current_weather = current_weather;
    this.direction = Math.abs((int) (Math.random() * 4));
  }
}
