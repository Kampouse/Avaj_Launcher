package  aircraft;

public class Coordinates {
  public int longitude;
  public int latitude;
  public int height;
  public Coordinates(int longitude, int latitude, int height) {
    this.longitude = longitude;
    this.latitude = latitude;
    this.height = height;
  }
  
  public int get_longitude() {
    return longitude;
  } 
  public int get_latitude() {
    return latitude;
  }
  public int get_height() {
    return height;
  }

}
