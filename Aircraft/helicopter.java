package aircraft;

import aircraft.*;
import tower.*;
import java.util.HashMap;

public class helicopter extends aircraft implements flyable {

String RainMessage[] = {
  "It's raining. Please be aware that rain may affect helicopter flights.",
  "Don't forget your umbrella! Rainy weather can impact helicopter operations.",
  "Stay dry and cozy indoors while it's raining. Check for any updates on helicopter flights.",
  "The sound of rain can be so soothing, but it may affect helicopter operations and schedules.",
  "Rainy days are perfect for curling up with a good book, especially if your helicopter flight is delayed.",
  "Remember to drive carefully on wet roads while heading to the helicopter departure point.",
  "Grab a hot cup of coffee and keep an eye on any notifications regarding helicopter flights during the rainy weather.",
  "Raindrops keep falling on my head, but I'm hoping for clear skies for my helicopter adventure.",
  "The rain is nature's way of watering the plants and flowers, but it can also disrupt helicopter flights.",
  "Dancing in the rain can be a fun and liberating experience, but it may not be suitable for helicopter rides."
};

String FogMessage[] = {
  "It's foggy. Please be aware that fog may affect helicopter flights.",
  "Be cautious while driving in foggy conditions when heading to the helicopter departure point.",
  "The fog adds a mysterious touch to the surroundings, but it can hinder visibility for helicopter flights.",
  "Take it slow and steady in the fog to stay safe, especially if you have a helicopter ride scheduled.",
  "Foggy days create a sense of tranquility and peace, but they can affect helicopter operations.",
  "Visibility might be reduced, so be mindful of your surroundings and any updates regarding helicopter flights.",
  "Enjoy the ethereal beauty of the foggy landscape, but stay informed about any changes to helicopter rides.",
  "Fog can make familiar places seem entirely new and enchanting, but it may impact helicopter schedules.",
  "Carry a flashlight for better visibility in the fog, especially while participating in helicopter activities.",
  "The fog will dissipate, revealing a clear day ahead, hopefully allowing helicopter flights to proceed."
};

String SnowMessage[] = {
  "It's snowing. Please be prepared for possible delays or cancellations in helicopter flights.",
  "Bundle up and stay warm in this snowy weather, and check for any updates on your helicopter flight.",
  "Watch your step on slippery, icy surfaces while heading to the helicopter departure point for your flight.",
  "Let's build a snowman and have some winter fun, but remember to stay informed about any changes to helicopter rides.",
  "Snowflakes falling gently from the sky create a magical atmosphere, but they can impact helicopter operations.",
  "Drive with caution on snowy roads when heading to the helicopter departure point for your flight.",
  "Embrace the beauty of a winter wonderland, but stay updated about any disruptions to helicopter flights.",
  "Hot cocoa and snow days are the perfect combination, but they may affect helicopter schedules.",
  "Put on your snow boots and go for a snowy adventure, but keep an eye on any updates regarding helicopter rides.",
  "Snow brings out the childlike joy in all of us, but it may impact the feasibility of helicopter flights."
};

String SunMessage[] = {
  "It's sunny. Enjoy the beautiful weather for your helicopter flight!",
  "Clear blue skies and sunshine make for a perfect day to go flying in a helicopter.",
  "Stay hydrated and seek shade during the peak sun hours while preparing for your helicopter adventure.",
  "It's a great day to go for a walk or spend time outdoors, especially before your helicopter flight.",
  "Make the most of the sunshine and have a relaxing time at the helicopter departure point before your flight.",
  "Sunglasses and a hat will help protect your eyes and skin from the sun during your helicopter ride.",
  "Appreciate the warmth and brightness that the sun brings, especially during your helicopter experience.",
  "Sunshine can uplift your mood and create an enjoyable atmosphere for your helicopter flight.",
  "Take a break and relax under the glorious sun rays before boarding your helicopter.",
  "Enjoy the sunny weather and have an unforgettable journey on your helicopter ride!"
};


  final String type = "helicopter";
  String current_weather;
  weathertower weathertower;

  public String getType() {
    return type;
  }

  final HashMap<String, Coordinates> alititudeModifier = new HashMap<String, Coordinates>();
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
@Override
  public String get_name() {
    return this.name;
  }




  public helicopter(String name, Coordinates coordinates, String current_weather) {
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
