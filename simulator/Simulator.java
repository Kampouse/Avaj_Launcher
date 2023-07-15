
package simulator; //  

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;
import java.lang.Integer.*;
import java.util.Arrays;
import java.util.Vector;
import parser.Parser;
import aircraft.*;
import tower.*;
import java.util.concurrent.TimeUnit;

public class Simulator {
	Vector<flyable> aircrafts;
	int timeline;
	weatherprovider weather = weatherprovider.getProvider();

	private void clear_screen () {
		final String ANSI_CLS = "\u001b[2J";
		final String ANSI_HOME = "\u001b[H";
		System.out.print(ANSI_CLS + ANSI_HOME);
		System.out.flush();
	}
	private  void map_printer(int time_at) {
		
		 
		for (int j = 0; j < 50; j++) {	
		  //System.out.print("|");
		  
		for (int i = 1; i < 50 ; i++) {
			//System.out.print(weather.getCurrentWeather(new Coordinates( i, j,50)));;
			  		  
			//System.out.print("_");
		}
		  //System.out.println("|");
		}
	}

	void get_crafts_weather(weathertower tower) {
		for (int i = 0; i < aircrafts.size(); i++) {
			 //tower.getweather( aircrafts.get(i).get_pos());
			//System.out.println( weather.getCurrentWeather(aircrafts.get(i).get_pos()));
		aircrafts.get(i).updateConditions();

	  //cast(aircrafts.get(i).getClass().cast(aircrafts.get(i))).updateConditions();
			 //cast to to the child class
		
		}
	}


	public Simulator(Parser parser) {
		weathertower tower = new weathertower();
		aircrafts = parser.init();

		timeline = parser.getTimeline();
	for (int i = 0; i < aircrafts.size(); i++) {
		aircrafts.get(i).registerTower(tower);
	}

	for (int i = 0; i < timeline; i++) {
		//clear_screen();
		get_crafts_weather(tower);
		map_printer(i);
		try  {
		 Thread.sleep(1);
		}
		catch (InterruptedException e) {
			System.out.println("Error");
		}
	}





		}
}
