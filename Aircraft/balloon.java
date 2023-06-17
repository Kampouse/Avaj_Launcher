package aircraft;
import aircraft.*;
import tower.*;

public class balloon extends  aircraft implements  flyable{

   
  final String type = "balloon";
   public  String getType() {
    return type;
   }

  @Override
  public void updateConditions() {
     System.out.println("balloon#" + this.name + "(" + this.id + "): " + "Let's enjoy the good weather and take some pics.");
    
  }
  
  @Override 
  public void registerTower(weathertower weatherTower) {
    // TODO Auto-generated method stub
    
  }
 
  public balloon(String name, Coordinates coordinates) {
    super(name, coordinates);
    // TODO Auto-generated constructor stub
  }
@Override 
  public String get_type() {
    return  type;
    
  }
@Override 
  public Coordinates get_pos() {
    return  this.coordinates;
    
  }
}
  
