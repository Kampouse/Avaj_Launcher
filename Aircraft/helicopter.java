package aircraft;

import aircraft.*;
import tower.*;

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

  public helicopter(String name, Coordinates coordinates, String current_weather) {
    super(name, coordinates, current_weather);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void updateConditions() {

    this.current_weather = weathertower.getweather(this.coordinates);
    weathertower.changeWeather(this.coordinates);
    weathertower.getweather(this.coordinates);

    String message = get_possible_message();
    String type = getType();
    String name = this.name;

    String output = type + "#" + name + "(" + this.coordinates.get_longitude() + "," + this.coordinates.get_latitude()
        + "," + this.coordinates.get_height() + ") " + message;
    System.out.println(output);
  }

  @Override
  public String get_possible_message() {
    // make hashmap wit string and function
    if (this.current_weather == "RAIN") {
      return RainMessage();
    } else if (this.current_weather == "FOG") {
      return FogMessage();
    } else if (this.current_weather == "SNOW") {
      return SnowMessage();
    } else if (this.current_weather == "SUN") {
      return SunMessage();
    } else {
      return "Error";
    }

  }

  @Override
  public void registerTower(weathertower weatherTower) {
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

  @Override
  public String RainMessage() {
    return " It's raining. Better watch out for lightings";
  }

  @Override
  public String FogMessage() {
    return " It's foggy. Better watch out for lightings";
  }

  @Override
  public String SnowMessage() {
    return " It's snowing. We're  gonna crash";
  }

  @Override
  public String SunMessage() {
    return " It's sunny. We're  gonna crash";
  }

}
