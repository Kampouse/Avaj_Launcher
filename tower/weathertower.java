package tower;
import tower.*;
import aircraft.*;
import java.util.HashMap;

public class weathertower extends  tower {

    HashMap<Coordinates, String> weathers = new HashMap<Coordinates, String>();
    //provide  weather for the aircrafts 
    weatherprovider weatherprovider = new weatherprovider();
    
   public String getweather(Coordinates cords) {
 //         weathers.get(cords); 
 //         #TODO check update this to be less randomy
         //System.out.println("weather is " + weatherprovider.getCurrentWeather(cords));
         return  weatherprovider.getCurrentWeather(cords);
   }

   // @brief  chagne the weather at certain coordinates 
   // @param  cords  coordinates of the aircraft
   public  void changeWeather(Coordinates cords ) {
//TODO fix this  if this is the right way to do it
       weatherprovider.setWeather(cords);
         conditionsChanged();
      }

   //@brief fire when the weather changes  send a message to the aircrafts
   void conditionsChanged() {
      //observer come from the tower class 
             for (int i = 0; i < observers.size(); i++) {
               
                // i think this look this look with a weather provider but idk
                     observers.get(i).updateConditions();
             }
     }
	
}    
