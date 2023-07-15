package   aircraft;

import  tower.*;
public interface    flyable {
  public String RainMessage();
  public String FogMessage();
  public String SnowMessage();
  public String SunMessage();
  public void updateConditions();
  public void registerTower(weathertower weatherTower);
  public Coordinates get_pos();
  public String get_type();
  public String get_possible_message();

}
