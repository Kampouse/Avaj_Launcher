package aircraft;

import aircraft.*;
import java.util.HashMap;
import tower.*;

public class balloon extends aircraft implements flyable {

  final String type = "balloon";


String RainMessage[] = {
  "It's raining. Balloon flights may be canceled due to weather conditions.",
  "Don't forget your umbrella! Rainy weather can affect hot air balloon operations.",
  "Stay dry and cozy indoors while it's raining. Check for any updates on balloon flights.",
  "The sound of rain can be so soothing, but it may prevent hot air balloon flights from taking off.",
  "Rainy days are perfect for curling up with a good book, especially if your balloon flight is canceled.",
  "Remember to drive carefully on wet roads while heading to the balloon launch site.",
  "Grab a hot cup of coffee and keep an eye on any notifications regarding balloon flights during the rainy weather.",
  "Raindrops keep falling on my head, but I'm hoping for clear skies for my balloon adventure.",
  "The rain is nature's way of watering the plants and flowers, but it can also delay balloon flights.",
  "Dancing in the rain can be a fun and liberating experience, but it may not be suitable for balloon rides."
};

String FogMessage[] = {
  "It's foggy. Balloon flights may be delayed or canceled due to low visibility.",
  "Be cautious while driving in foggy conditions when heading to the balloon launch site.",
  "The fog adds a mysterious touch to the surroundings, but it can hinder visibility for balloon flights.",
  "Take it slow and steady in the fog to stay safe, especially if you have a hot air balloon ride scheduled.",
  "Foggy days create a sense of tranquility and peace, but they can affect hot air balloon operations.",
  "Visibility might be reduced, so be mindful of your surroundings and any updates regarding balloon flights.",
  "Enjoy the ethereal beauty of the foggy landscape, but stay informed about any changes to balloon rides.",
  "Fog can make familiar places seem entirely new and enchanting, but it may impact hot air balloon schedules.",
  "Carry a flashlight for better visibility in the fog, especially while participating in balloon activities.",
  "The fog will dissipate, revealing a clear day ahead, hopefully allowing balloon flights to proceed."
};

String SnowMessage[] = {
  "It's snowing. Balloon flights may be affected or postponed due to snowy conditions.",
  "Bundle up and stay warm in this snowy weather, and check for any updates on your balloon flight.",
  "Watch your step on slippery, icy surfaces while heading to the balloon launch site for your flight.",
  "Let's build a snowman and have some winter fun, but remember to stay informed about any changes to balloon rides.",
  "Snowflakes falling gently from the sky create a magical atmosphere, but they can impact hot air balloon operations.",
  "Drive with caution on snowy roads when heading to the balloon launch site for your flight.",
  "Embrace the beauty of a winter wonderland, but stay updated about any disruptions to balloon flights.",
  "Hot cocoa and snow days are the perfect combination, but they may affect hot air balloon schedules.",
  "Put on your snow boots and go for a snowy adventure, but keep an eye on any updates regarding balloon rides.",
  "Snow brings out the childlike joy in all of us, but it may impact the feasibility of hot air balloon flights."
};

String SunMessage[] = {
  "It's sunny. Enjoy the beautiful weather for your hot air balloon flight!",
  "Clear blue skies and sunshine make for a perfect day to go ballooning.",
  "Stay hydrated and seek shade during the peak sun hours while preparing for your balloon adventure.",
  "It's a great day to go for a walk or spend time outdoors, especially before your hot air balloon flight.",
  "Make the most of the sunshine and have a relaxing time at the balloon launch site before your flight.",
  "Sunglasses and a hat will help protect your eyes and skin from the sun during your balloon ride.",
  "Appreciate the warmth and brightness that the sun brings, especially during your hot air balloon experience.",
  "Sunshine can uplift your mood and create an enjoyable atmosphere for your balloon flight.",
  "Take a break and relax under the glorious sun rays before boarding your hot air balloon.",
  "Enjoy the sunny weather and have an unforgettable journey on your hot air balloon ride!"
};











final HashMap<String, Coordinates  >  alititudeModifier = new HashMap<String, Coordinates>();
  {
    alititudeModifier.put("SUN", new Coordinates(2, 0,4));
    alititudeModifier.put("FOG", new Coordinates(1, 0, -3));
    alititudeModifier.put("RAIN", new Coordinates(0, 0,-5));
    alititudeModifier.put("SNOW",  new Coordinates(0, 0, -15));
  }

  final HashMap<String, String[]> weatherMessage = new HashMap<String, String[]>();
  {
    weatherMessage.put("RAIN", RainMessage);
    weatherMessage.put("FOG", FogMessage);
    weatherMessage.put("SUN", SunMessage);
    weatherMessage.put("SNOW", SnowMessage);
  }







  weathertower weathertower;
  String current_weather;

  public String getType() {
    return type;
  }
  @Override
  public String get_name() {
    return this.name;
  }
   
  @Override 
  public void updateConditions() {
    this.current_weather = weathertower.getweather(this.coordinates);
    weathertower.changeWeather(this.coordinates);
    weathertower.getweather(this.coordinates);
    this.alititudeModifier.get(this.current_weather);
    this.updateCoords(this.alititudeModifier.get(this.current_weather));
    String message = this.weahterEffect(this.current_weather, this.weatherMessage);
    String type = getType();
    String name = this.name;
    String output = type + "#" + name + "(" + this.coordinates.get_longitude() +
    "," + this.coordinates.get_latitude() + "," + this.coordinates.get_height() + ") " + message;
    System.out.println(output);
  }

  @Override
  public void registerTower(weathertower weatherTower) {
     System.out.println("Tower says:" + this.type + "#" + this.name + "(" + this.id + ") registered to weather tower.");

    weathertower = weatherTower;
    
    // TODO Auto-generated method stub

  }

  public balloon(String name, Coordinates coordinates, String current_weather) {
    super(name, coordinates, current_weather);
  
    // TODO Auto-generated constructor stub
  }

  @Override
  public String get_type() {
    return type;

  }

  @Override
  public Coordinates get_pos() {
    return this.coordinates;

  }


}
