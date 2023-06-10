package  aircraft;
import aircraft.*; 

public  class  aircraftfactory extends  aircraft {
    
   public aircraftfactory() {
     super(" ", new Coordinates(0, 0, 0));
   }

     public  aircraftfactory (String name, Coordinates coordinates) {
     super(name, coordinates);
   }
    public aircraft newBalloon(String name, Coordinates coordinates) {
      return new balloon(name, coordinates);
    }
   public aircraft newHelicopter(String name, Coordinates coordinates) {
     return new helicopter(name, coordinates);
   }
   public aircraft newJetplane(String name, Coordinates coordinates) {
     return new jetplane(name, coordinates);
   }

 }
