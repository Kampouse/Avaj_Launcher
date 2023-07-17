package aircraft;

import aircraft.*;
import tower.*;
import java.util.HashMap;

public class helicopter extends aircraft implements flyable {

  String RainMessage[] = { " It's raining. Better watch out for lightings" };
  String FogMessage[] = { " It's foggy. Better watch out for lightings" };
  String SnowMessage[] = { " It's snowing. We're  gonna crash" };
  String SunMessage[] = { " It's sunny. We're  gonna crash" };

  final String type = "helicopter";
  String current_weather;
  weathertower weathertower;

  public String getType() {
    return type;
  }

  final HashMap<String, Integer> alititudeModifier = new HashMap<String, Integer>();
  {
    alititudeModifier.put("RAIN", 5);
    alititudeModifier.put("FOG", 1);
    alititudeModifier.put("SUN", 10);
    alititudeModifier.put("SNOW", -7);
  }

  final HashMap<String, String[]> weatherMessage = new HashMap<String, String[]>();
  {
    weatherMessage.put("RAIN", RainMessage);
    weatherMessage.put("FOG", FogMessage);
    weatherMessage.put("SUN", SunMessage);
    weatherMessage.put("SNOW", SnowMessage);
  }

  public helicopter(String name, Coordinates coordinates, String current_weather) {
    super(name, coordinates, current_weather);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void updateConditions() {

    this.current_weather = weathertower.getweather(this.coordinates);
    weathertower.changeWeather(this.coordinates);
    weathertower.getweather(this.coordinates);
    this.alititudeModifier.get(this.current_weather);
    this.updateCoords(this.alititudeModifier.get(this.current_weather));
    String message = this.weahterEffect(this.current_weather, this.weatherMessage);
    String type = getType();
    String name = this.name;
    String output = type + "#" + name + "(" + this.coordinates.get_longitude() +
        "," + this.coordinates.get_latitude() + "," + this.coordinates.get_height() + ") " + message;
    System.out.println(output);

  }

  @Override
  public void registerTower(weathertower weatherTower) {

    System.out.println("Tower says:" + this.type + "#" + this.name + "(" + this.id + ") registered to weather tower.");
    this.weathertower = weatherTower;

  }

  @Override
  public String get_type() {
    return type;

  }

  @Override
  public Coordinates get_pos() {
    return this.coordinates;

  }

}
