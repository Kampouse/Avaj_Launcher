package tower;

import tower.*;
import aircraft.*;
import java.util.HashMap;

public class weathertower extends tower {

   HashMap<Coordinates, String> weathers = new HashMap<Coordinates, String>();
   // provide weather for the aircrafts
   weatherprovider weatherprovider = new weatherprovider();

   public String getweather(Coordinates cords) {
      // weathers.get(cords);
      // #TODO check update this to be less randomy
      // System.out.println("weather is " + weatherprovider.getCurrentWeather(cords));
      return weatherprovider.getCurrentWeather(cords);
   }

   // @brief chagne the weather at certain coordinates
   // @param cords coordinates of the aircraft
   public void changeWeather(Coordinates cords) {
      // TODO fix this if this is the right way to do it
      weatherprovider.setWeather(cords);
   }

   void land(flyable flyable, int index) {
      String type = flyable.get_type();
      String name = flyable.get_name();
      String output = type + "#" + name; 
System.out.println("///////////////////////////////////////////////////////////////");
      System.out.println(output + " landing.");
      System.out.println(output + " has unregistered from weather tower.");
      observers.remove(index);
System.out.println("///////////////////////////////////////////////////////////////");
   }

   // @brief fire when the weather changes send a message to the aircrafts
   public void conditionsChanged(int index) {
      // observer come from the tower class
      if (observers.get(index).get_pos().get_height() <= 0) {

         this.land(observers.get(index), index);
      }
   }

}
