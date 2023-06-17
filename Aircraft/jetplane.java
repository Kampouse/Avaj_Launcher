package  aircraft;
import aircraft.*;
import tower.*;

public class jetplane extends  aircraft implements  flyable{

  final String type = "jetplane";

   public  String getType() {
    return type;
   }

  public void updateConditions() {
    // TODO Auto-generated method stub
    
  }
  
  @Override 
  public void registerTower(weathertower weatherTower) {
    // TODO Auto-generated method stub
    
  }
 
   
  public jetplane(String name, Coordinates coordinates) {
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
  
