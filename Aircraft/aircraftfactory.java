package  aircraft;
import aircraft.*; 

public  class  aircraftfactory extends  aircraft {
    
   public aircraftfactory() {
     super(" ", new Coordinates(0, 0, 0));
   }

     public  aircraftfactory (String name, Coordinates coordinates) {
     super(name, coordinates);
   }
    public flyable newBalloon(String name, Coordinates coordinates) {

      return new balloon(name, coordinates);
    }
   public flyable newHelicopter(String name, Coordinates coordinates) {
     return new helicopter(name, coordinates);
   }
   public flyable newJetplane(String name, Coordinates coordinates) {
     return new jetplane(name, coordinates);
   }

 }
