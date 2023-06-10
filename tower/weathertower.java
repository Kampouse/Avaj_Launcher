package tower;
import tower.*;
import aircraft.*;
import java.util.HashMap;

public class weathertower extends  tower {
    HashMap<Coordinates, String> weathers = new HashMap<Coordinates, String>();
   void getweather (Coordinates cords) {
          weathers.get(cords); 
       
   }

   // @brief  chagne the weather at certain coordinates
   // @param  cords  coordinates of the aircraft
   void changeWeather(Coordinates cords) {
       

   }

   void conditionsChanged() {
             for (int i = 0; i < observers.size(); i++) {
                // i think this look this look with a weather provider but idk
                     observers.get(i).updateConditions();
             }
     }
	
}    
