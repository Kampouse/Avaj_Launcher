package  aircraft;
import aircraft.*; 

public abstract  class aircraft {
   long id;    
   String name;
   Coordinates coordinates;
   private long idCounter = 0;
    private long nextId() {
      return id = ++idCounter;
       }
    
   aircraft (String name, Coordinates coordinates) {
      this.name = name;
      this.id = nextId();
      this.coordinates = coordinates;
   } 
}







