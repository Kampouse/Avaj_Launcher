package aircraft;

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

  aircraft(String name, Coordinates coordinates, String current_weather) {
    this.name = name;
    this.id = nextId();
    this.coordinates = coordinates;
    this.current_weather = current_weather;
  }


}
