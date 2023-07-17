package tower;

import aircraft.aircraft;
import aircraft.flyable;
import java.util.Vector;

public abstract class tower {

	Vector<flyable> observers = new Vector<flyable>();

	public void registerAirCraft(flyable aircraft) {
		observers.add(aircraft);
	}

	public void unregisterAirCraft(flyable aircraft) {
		observers.remove(aircraft);
	}

	public Vector<flyable> get_observers() {
		return observers;
	}

}
