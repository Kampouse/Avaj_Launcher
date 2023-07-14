package  aircraft;
import aircraft.*;
import tower.*;

public class jetplane extends  aircraft implements  flyable{

  final String type = "jetplane";
   weathertower  weathertower;
   public  String getType() {
    return type;
   }
  public jetplane(String name, Coordinates coordinates) {
    super(name, coordinates);


    // TODO Auto-generated constructor stub
  }


    
  public void updateConditions() {
        
    //weathertower.changeWeather(this.coordinates);
    // TODO Auto-generated method stub
    
    
  }
  
  @Override 
  public void registerTower(weathertower weatherTower) {
     this.weathertower = weatherTower;

    
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
  
