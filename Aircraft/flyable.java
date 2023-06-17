package   aircraft;

import  tower.*;
public interface    flyable{
  public void updateConditions();
  public void registerTower(weathertower weatherTower);
  public Coordinates get_pos();
  public String get_type();

}
