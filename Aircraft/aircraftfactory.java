package  aircraft;
import aircraft.*; 

public  class  aircraftfactory extends  aircraft {
    
   public aircraftfactory() {
     super(" ", new Coordinates(0, 0, 0));
   }

     public  aircraftfactory (String name, Coordinates coordinates) {
     super(name, coordinates);
   }
   public aircraft  generator(String type, String name, Coordinates coordinates) {
     if (type == "balloon") {
       return new balloon(name, coordinates);
     }
     else if (type == "helicopter") {
       return new helicopter(name, coordinates);
     }
     else if (type == "jetplane") {
       return new jetplane(name, coordinates);
     }
     else {
       return null;
     }
   }

 }
