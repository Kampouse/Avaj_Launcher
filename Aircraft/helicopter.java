package  aircraft;
import aircraft.*;
import tower.*;

public class helicopter extends  aircraft implements  flyable{
  final String type = "helicopter";
   String current_weather;
  weathertower  weathertower;
   public  String getType() {
    return type;
   }
  public helicopter(String name, Coordinates coordinates, String current_weather) {
    super(name, coordinates, current_weather);
    // TODO Auto-generated constructor stub
  }
      
  @Override
  public void updateConditions() {
     
    weathertower.changeWeather(this.coordinates);
    // TODO Auto-generated method stub
   System.out.println("hello" +  weathertower.getweather(this.coordinates));
    
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
  
