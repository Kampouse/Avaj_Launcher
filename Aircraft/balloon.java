package aircraft;

import aircraft.*;
import tower.*;

public class balloon extends aircraft implements flyable {

  final String type = "balloon";

  weathertower weathertower;
  String current_weather;

  public String getType() {
    return type;
  }

  @Override
  public void updateConditions() {

    weathertower.changeWeather(this.coordinates);
    // TODO Auto-generated method stub
    //
    System.out.println("hello" + weathertower.getweather(this.coordinates));

  }

  @Override
  public void registerTower(weathertower weatherTower) {
    weathertower = weatherTower;
    // TODO Auto-generated method stub

  }

  public balloon(String name, Coordinates coordinates, String current_weather) {
    super(name, coordinates, current_weather);
    // TODO Auto-generated constructor stub
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
