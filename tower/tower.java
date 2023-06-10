package  tower;
import aircraft.aircraft;
import aircraft.flyable;
import java.util.Vector;
public abstract  class tower {
	 

	 Vector <flyable> observers = new Vector<flyable>();

	// @brief  register the aircraft from the tower
	 void registerAirCraft (flyable aircraft) {
		observers.add(aircraft);
	}
	// @brief  unregister the aircraft from the tower
	void unregisterAirCraft (flyable aircraft) {
		observers.remove(aircraft);
	}
	// @brief  notify  all the aircrafts about the weather change
 

}
