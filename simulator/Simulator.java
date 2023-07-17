
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

	private void clear_screen() {
		final String ANSI_CLS = "\u001b[2J";
		final String ANSI_HOME = "\u001b[H";
		System.out.print(ANSI_CLS + ANSI_HOME);
		System.out.flush();
	}

	private void map_printer(int time_at) {

		for (int j = 0; j < 50; j++) {
			// System.out.print("|");

			for (int i = 1; i < 50; i++) {
				// System.out.print(weather.getCurrentWeather(new Coordinates( i, j,50)));;

				// System.out.print("_");
			}
			// System.out.println("|");
		}
	}

	void get_crafts_weather(weathertower tower) {

		Vector<flyable> Aircrafts = tower.get_observers();

		for (int i = 0; i < Aircrafts.size(); i++) {

			Aircrafts.get(i).updateConditions();
			tower.conditionsChanged(i);
			if (Aircrafts.size() == 0) {
				break;
			}
			System.out.println("Aircrafts size is " + Aircrafts.size());
		}

	}

	public Simulator(Parser parser) {
		weathertower tower = new weathertower();
		aircrafts = parser.init();
		timeline = parser.getTimeline();
		for (int i = 0; i < aircrafts.size(); i++) {
			aircrafts.get(i).registerTower(tower);
			tower.registerAirCraft(aircrafts.get(i));
		}
		for (int i = 0; i < timeline; i++) {
			try {
				clear_screen();
				System.out.println("Time is " + i + "----------------------------------------------- ");
				get_crafts_weather(tower);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
		}
	}
}
