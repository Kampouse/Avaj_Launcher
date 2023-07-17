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
  public Coordinates normalize(int height) {
    return new Coordinates(this.longitude, this.latitude, height);
  }
  public void to_string() {
    System.out.println("longitude: " + longitude + " latitude: " + latitude + " height: " + height + '\n');
  }
  public void set_longitude(int longitude) {
    this.longitude = longitude;
  }
  public void set_latitude(int latitude) {
    this.latitude = latitude;
  }
  public void set_height(int height) {
     
    this.height = height < 0 ? 0 : height > 100 ? 100 : height;
  }
  public void variation (Coordinates variation) {

    if (this.height + variation.height < 0) {
      this.height = 0;
    } else if (this.height + variation.height > 100) {
      this.height = 100;
    } else {
      this.height += variation.height;
    }
    if (this.longitude + variation.longitude < 0) {
      this.longitude = 0;
    } else if (this.longitude + variation.longitude > 1000) {
      this.longitude = 999;
    } else {
      this.longitude += variation.longitude;
    }
    if (this.latitude + variation.latitude < 0) {
      this.latitude = 0;
    } else if (this.latitude + variation.latitude > 1000) {
      this.latitude = 999;
    } else {
      this.latitude += variation.latitude;
    }


  }

}
