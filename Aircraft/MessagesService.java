import aircraft.*;
import java.util.HashMap;

public class MessagesService {
   flyable aircraft;
   // list all of the weahter messages here

    MessagesService(flyable aircraft, String weather) {
      this.aircraft = aircraft;

    }
    String weatherMessage ()  {
      this.aircraft.get_type();
      return "Tower says: ";

    }


}

