package aircraft;

import aircraft.*;
import tower.*;
import java.util.HashMap;

public class jetplane extends aircraft implements flyable {


String RainMessage[] = {
  "It's raining. Please note that rain may cause delays in flights.",
  "Don't forget your umbrella! Rainy weather can affect flight operations.",
  "Stay dry and cozy indoors while it's raining. Check for any flight updates.",
  "The sound of rain can be so soothing, but it may impact flight schedules.",
  "Rainy days are perfect for curling up with a good book, especially if your flight is delayed.",
  "Remember to drive carefully on wet roads while heading to the airport.",
  "Grab a hot cup of coffee and keep an eye on your flight status during the rainy weather.",
  "Raindrops keep falling on my head, but I'm hoping for clear skies for my flight.",
  "The rain is nature's way of watering the plants and flowers, but it can also disrupt flights.",
  "Dancing in the rain can be a fun and liberating experience, but don't miss your flight!"
};

String FogMessage[] = {
  "It's foggy. Please be aware that fog may cause delays or cancellations in flights.",
  "Be cautious while driving in foggy conditions when heading to the airport.",
  "The fog adds a mysterious touch to the surroundings, but it can impact visibility for flights.",
  "Take it slow and steady in the fog to stay safe, especially if you have a flight to catch.",
  "Foggy days create a sense of tranquility and peace, but they can disrupt flight operations.",
  "Visibility might be reduced, so be mindful of your surroundings and any flight announcements.",
  "Enjoy the ethereal beauty of the foggy landscape, but check for any flight updates.",
  "Fog can make familiar places seem entirely new and enchanting, but it can affect flight schedules too.",
  "Carry a flashlight for better visibility in the fog, especially while navigating the airport.",
  "The fog will dissipate, revealing a clear day ahead, hopefully improving flight conditions."
};

String SnowMessage[] = {
  "It's snowing. Please be prepared for possible flight delays or cancellations.",
  "Bundle up and stay warm in this snowy weather, and check your flight status.",
  "Watch your step on slippery, icy surfaces while heading to the airport for your flight.",
  "Let's build a snowman and have some winter fun, but remember to keep track of any flight changes.",
  "Snowflakes falling gently from the sky create a magical atmosphere, but they can affect flights.",
  "Drive with caution on snowy roads when heading to the airport for your flight.",
  "Embrace the beauty of a winter wonderland, but stay informed about any flight disruptions.",
  "Hot cocoa and snow days are the perfect combination, but they may impact flight operations.",
  "Put on your snow boots and go for a snowy adventure, but keep an eye on your flight schedule.",
  "Snow brings out the childlike joy in all of us, but it can also cause flight delays or cancellations."
};

String SunMessage[] = {
  "It's sunny. Enjoy the beautiful weather before your flight takes off!",
  "Clear blue skies and sunshine make for a perfect day to travel.",
  "Stay hydrated and seek shade during the peak sun hours while waiting for your flight.",
  "It's a great day to go for a walk or spend time outdoors, but remember your flight time.",
  "Make the most of the sunshine and have a relaxing time at the airport before your flight.",
  "Sunglasses and a hat will help protect your eyes and skin from the sun during your travel.",
  "Appreciate the warmth and brightness that the sun brings, especially during your flight.",
  "Sunshine can uplift your mood and boost your energy levels, perfect for a smooth flight.",
  "Take a break and relax under the glorious sun rays before boarding your flight.",
  "Enjoy the sunny weather and have a pleasant journey on your flight!"
};


  int id;

   //make a hashmap with string and function
 final HashMap<String, Coordinates  >  alititudeModifier = new HashMap<String, Coordinates>();
  {
    alititudeModifier.put("SUN", new Coordinates(10, 0, -100));
    alititudeModifier.put("FOG", new Coordinates(1, 0, -100));
    alititudeModifier.put("RAIN", new Coordinates(5, 0, -100));
    alititudeModifier.put("SNOW",  new Coordinates(0, 0, -100));
  }

  final HashMap<String, String[]> weatherMessage = new HashMap<String, String[]>();
  {
    weatherMessage.put("RAIN", RainMessage);
    weatherMessage.put("FOG", FogMessage);
    weatherMessage.put("SUN", SunMessage);
    weatherMessage.put("SNOW", SnowMessage);
  }
  


  final String type = "jetplane";
  weathertower weathertower;
  String current_weather;

  public String getType() {
    return type;
  }
  @Override
  public String get_name() {
    return this.name;
  }

  public jetplane(String name, Coordinates coordinates, String current_weather) {
    super(name, coordinates, current_weather);

    // TODO Auto-generated constructor stub
  }
@Override
  public void updateConditions() {
    this.current_weather = weathertower.getweather(this.coordinates);
    weathertower.changeWeather(this.coordinates);
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
    this.weathertower = weatherTower;
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
