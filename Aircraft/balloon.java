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
    // TODO Auto-generated method stub
    
  }
  
  @Override 
  public void registerTower(weathertower weatherTower) {
    // TODO Auto-generated method stub
    
  }
 
  public balloon(String name, Coordinates coordinates) {
    super(name, coordinates);
    // TODO Auto-generated constructor stub
  }
}
  