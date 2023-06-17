package  aircraft;
import aircraft.*;
import tower.*;

public class helicopter extends  aircraft implements  flyable{
  final String type = "helicopter";
   public  String getType() {
    return type;
   }

  @Override
  public void updateConditions() {
    // TODO Auto-generated method stub
    
  }
  
  @Override 
  public void registerTower(weathertower weatherTower) {
    // TODO Auto-generated method stub
    
  }
@Override 
  public String get_type() {
    return  type;
    
  }
@Override 
  public Coordinates get_pos() {
    return  this.coordinates;
    
  }
 
 
 
   
  public helicopter(String name, Coordinates coordinates) {
    super(name, coordinates);
    // TODO Auto-generated constructor stub
  }
   

}
  
